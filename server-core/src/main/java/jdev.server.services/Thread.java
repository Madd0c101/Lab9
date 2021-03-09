package jdev.server.services;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.apache.tomcat.jni.Time.sleep;

public class Thread {
    private static final Logger log = LoggerFactory.getLogger(Thread.class);
    static int account = 0;
    static int transNum = 10000;
    static int threadNum = 200;
    static ReentrantLock lock = new ReentrantLock();
    static ExecutorService executor = Executors.newFixedThreadPool(threadNum);
   public static void increment() {
        lock.lock();
        try {
            account=account+transNum;
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

        if (executor.isShutdown())
        {
            //если мы здесь то значит все нити завершили выполнение, выводим результат
            log.info("account = [" + account + "]" + " must be = [" + transNum*threadNum + "]");

            //удивляемся если разница не равна нулю
            if (transNum*threadNum - account != 0)
                log.info("where is my : " + (transNum*threadNum - account) + "$ !!!!!");
        }
    }

}