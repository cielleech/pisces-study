package org.vox.study.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rookie.lee on 2017/5/31.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch lock = new CountDownLatch(1);

        ExecutorService service = Executors.newFixedThreadPool(10);

        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start runnable thread");
                    lock.await();
                    System.out.println("end runnable thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("lock count down");
        lock.countDown();

        service.shutdown();
    }
}
