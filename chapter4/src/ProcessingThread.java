/**
 * Created by hwb on 2015/12/20.
 */
package com.java7developer.chapter4;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class ProcessingThread extends Thread {
    private static int MAX_THREADS = 4;
    private final String ident;
    private final CountDownLatch latch;

    public ProcessingThread(String ident_, CountDownLatch cdl_) {
        ident = ident_;
        latch = cdl_;
    }

    public String getIdentifier() {
        return ident;
    }

    public void initialize() {
        latch.countDown();
    }

    public void run() {
        System.out.println(latch.getCount());
        initialize();
    }

    public static void main(String[] a) {
        final int quorum = 1 + (int) (MAX_THREADS / 2);
        final CountDownLatch cdl = new CountDownLatch(quorum);

        final Set<ProcessingThread> nodes = new HashSet<>();
        try {
            for (int i = 0; i < MAX_THREADS; i++) {
                ProcessingThread local = new ProcessingThread(
                        "localhost:" + (9000 + i), cdl);
                nodes.add(local);
                local.start();
            }
            System.out.println("before await");
            cdl.await();
            System.out.println("after await");
        } catch (InterruptedException e) {

        } finally {
        }
    }
}
