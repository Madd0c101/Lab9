package jdev.server.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodThreads {
    private static final Logger log = LoggerFactory.getLogger(GoodThreads.class);
    static int account = 0;
    static int transNum = 10000;
    static int threadNum = 200;
    static ReentrantLock lock = new ReentrantLock();
    static ReentrantLock first = new ReentrantLock();
    static ReentrantLock second = new ReentrantLock();
    static ExecutorService executor = Executors.newFixedThreadPool(threadNum);
    static int attemptNum =0;
    public static void increment() {
        lock.lock();
        try {
            account = account + transNum;
        } finally {
            lock.unlock();
        }
    }

    public static void start() throws InterruptedException {

        IntStream.range(0, threadNum)
                .forEach(i -> executor.submit(() -> {
                    increment();
                }));

        executor.awaitTermination(3L, TimeUnit.SECONDS);
        executor.shutdown();

        if (executor.isShutdown()) {
            //если мы здесь то значит все нити завершили выполнение, выводим результат
            log.info("account = [" + account + "]" + " must be = [" + transNum * threadNum + "]");

            //удивляемся если разница не равна нулю
            if (transNum * threadNum - account != 0)
                log.info("where is my : " + (transNum * threadNum - account) + "$ !!!!!");
        }

//Livelock Example
        Runnable locker = () -> {
            boolean firstLocked = false;
            boolean secondLocked = false;
            try {
                while (!firstLocked || !secondLocked) {
                    firstLocked = first.tryLock(100, TimeUnit.MILLISECONDS);
                    Calc("First Locked: " + firstLocked);
                    secondLocked = second.tryLock(100, TimeUnit.MILLISECONDS);
                    Calc("Second Locked: " + secondLocked);
                    attemptNum++;
                }
                first.unlock();
                second.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        if (attemptNum <10) {
        new Thread(locker).start();
        new Thread(locker).start();
        }

    }

    public static void Calc(String text) {
        String name = Thread.currentThread().getName(); //like Thread-1 or Thread-0
        String say = " noThread";
        int val = Integer.valueOf(name.substring(name.lastIndexOf("-") + 1)) + 1;
        if (val != 0) {
            say = " OK";
        }
        log.info(name + ": " + text+say);
        try {
            log.info(name + ": wait for " + val + " sec");
            Thread.currentThread().sleep(val * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}