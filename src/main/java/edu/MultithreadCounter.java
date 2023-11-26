package edu;

import java.util.concurrent.atomic.AtomicLong;

public class MultithreadCounter {
    private final AtomicLong counter;

    public MultithreadCounter() {
        this.counter = new AtomicLong(0);
    }

    public long countToNumber(long iterations, int numberOfThreads) {

        if (iterations < 0 || numberOfThreads < 1) {
            return 0;
        }

        counter.set(0);

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> incrementCounterNTimes(iterations / numberOfThreads));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return counter.get();
    }

    private void incrementCounterNTimes(long times) {
        for (long i = 0; i < times; i++) {
            counter.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        var counter = new MultithreadCounter();
        counter.countToNumber(60000, 4);
        System.out.println(counter.counter);
    }
}
