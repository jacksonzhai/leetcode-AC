package ThreadPool;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolTest {
    public static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void runTest() {
        AtomicLong i = new AtomicLong(0);
        Runtime.getRuntime().addShutdownHook(new closeHook());
        while (true) {
            try {
                Thread.sleep(1000);
                executorService.execute(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println(i.getAndIncrement());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class closeHook extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("closing...");
                executorService.shutdown();
                while (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                    System.out.println("service not stop");
                }
                System.out.println("all thread complete");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
