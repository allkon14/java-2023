package edu.task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class MonteCarloPiParallel {
    private static final AtomicLong INSIDE_CIRCLE = new AtomicLong(0);

    public static double calculatePi(int numThreads, long numSimulations) {
        INSIDE_CIRCLE.set(0);

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> simulatePoints(numSimulations / numThreads));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        double ratio = INSIDE_CIRCLE.get() / (double) numSimulations;

        return 4 * ratio;
    }

    private static void simulatePoints(long numPoints) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < numPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double distance = Math.sqrt(x * x + y * y);

            if (distance <= 1) {
                INSIDE_CIRCLE.incrementAndGet();
            }
        }
    }
}
