package edu;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class Task4 {
    private Task4() {
    }

    public static double calculatePi(int iterations) {
        int circleCount = 0;
        int totalCount = 0;

        for (int i = 0; i < iterations; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            double distance = Math.sqrt(x * x + y * y);

            if (distance <= 1) {
                circleCount++;
            }

            totalCount++;
        }

        return 4.0 * (circleCount / (double) totalCount);
    }

    public static class MonteCarloPi {
        private static AtomicLong insideCircle = new AtomicLong(0);
        private static long totalPoints;

        public static double calculatePi(int numThreads, long numSimulations) {
            totalPoints = numSimulations;
            insideCircle.set(0);

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

            double ratio = insideCircle.get() / (double) totalPoints;

            return 4 * ratio;
        }

        private static void simulatePoints(long numPoints) {
            ThreadLocalRandom random = ThreadLocalRandom.current();

            for (int i = 0; i < numPoints; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();
                double distance = Math.sqrt(x * x + y * y);

                if (distance <= 1) {
                    insideCircle.incrementAndGet();
                }
            }
        }
    }

    private static final List<Integer> ITERATIONS = List.of(10_000_000, 100_000_000, 1_000_000_000);

    public static void main(String[] args) {
        System.out.printf("%-15s %-15s %-6s\n", "Value", "Difference", "Time");
        double[] timesSeq = new double[ITERATIONS.size()];
        for (int i = 0; i < ITERATIONS.size(); ++i) {
            int iters = ITERATIONS.get(i);
            long nanos1 = System.nanoTime();
            double res = calculatePi(iters);
            long nanos2 = System.nanoTime();
            double secs = (nanos2 - nanos1) / 1e9;
            System.out.printf("%.13f %.13f %.3f\n", res, Math.abs(res - Math.PI), secs);
            timesSeq[i] = secs;
        }

        System.out.println();
        int[] numThreads = {1, 2, 4, 8};
        long numSimulations = 10000000;

        for (int threads : numThreads) {
            double averageTime = measureAverageTime(threads, numSimulations);
            System.out.println("Среднее время ускорения для " + threads + " потоков: " + averageTime + " мс");
        }

        int[] numSimulationsArr = {10000000, 100000000, 1000000000};
        for (int simulations : numSimulationsArr) {
            double pi = calculatePiSingleThread(simulations);
            double error = Math.abs(Math.PI - pi);
            System.out.println("Погрешность для " + simulations + " симуляций: " + error);
        }
    }

    private static double measureAverageTime(int numThreads, long numSimulations) {
        int numExperiments = 10;
        long totalTime = 0;

        for (int i = 0; i < numExperiments; i++) {
            long startTime = System.currentTimeMillis();

            MonteCarloPi.calculatePi(numThreads, numSimulations);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            totalTime += elapsedTime;
        }

        return totalTime / (double) numExperiments;
    }

    private static double calculatePiSingleThread(long numSimulations) {
        return MonteCarloPi.calculatePi(1, numSimulations);
    }
}
