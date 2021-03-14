package jdev.server.services;
import javax.validation.constraints.AssertTrue;
import java.lang.*;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
public class BadThreads {
    static String message;
    static Object lock = new Object();
    static ReentrantLock lock2 = new ReentrantLock();
    static Integer j=0;
    static Integer k=0;
    static String word="";
    static Integer n=1000;
    static Boolean allow=false;
    private static class CorrectorThread extends java.lang.Thread {
        @Override
        public void run() {
        //    super.run();
            message = "Помиловать";
        }
    }

    public static class SetCallable
            implements Callable {
        private String word;
        public SetCallable(String word) {
            this.word = word;
        }

        public String call() throws InterruptedException {
            word="Помиловать";
            System.out.println(Thread.currentThread().getName() + ": вывод текста отдельным процессом " + word);
            //Thread.sleep(1);
            return word;
        }
    }


    public static void main(String args[])
            throws InterruptedException, ExecutionException {

        for (int i=0; i<n; i++) {
            CorrectorThread correctorThread = new CorrectorThread();
            message = "Казнить";
            Thread.sleep(10);
            correctorThread.start();
            try {
                correctorThread.join();
               // System.out.println("here");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println(Thread.currentThread().getState());
          //  Thread.sleep(10);
           // System.out.println(Thread.currentThread().getState());
            if (message.contains("Помиловать")) {
                j++;
            }
            if (message.contains("Казнить")) {
                k++;
            }
            System.out.println(message+" "+i);

           // if (correctorThread.currentThread().isInterrupted()) {

         //   }
}
        System.out.println(" Кол-во Помиловать="+j+"    Кол-во Казнить= "+k);
        allow=true;
        ExecutorService pool = Executors.newFixedThreadPool(n);
        Set<Future<String>> set = new HashSet<Future<String>>();
  if (allow) {
      for (int i = 0; i < n; i++) {
          word = "Казнить";
          Thread.sleep(10);
          Callable<String> callable = new SetCallable(word);
          Future<String> future = pool.submit(callable);
          set.add(future);
          System.out.println(Thread.currentThread().getName() + ": вывод текста мейном " + future.get());
      }
      int sum = 0;
      for (Future<String> future2 : set) {
          if (future2.get().contains("Помиловать"))
              sum++;
      }
      System.out.printf("Кол-во Помиловать= %s%n", sum);
      System.exit(sum);
      //  correctorThread.interrupt();
  }
    }
}
