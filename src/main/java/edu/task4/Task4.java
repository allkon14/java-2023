package edu.task4;

import java.util.List;

public class Task4 {
    private Task4() {
    }

    private static double measureAverageTime(int numThreads, long numSimulations) {
        int numExperiments = 10;
        long totalTime = 0;

        for (int i = 0; i < numExperiments; i++) {
            long startTime = System.currentTimeMillis();

            MonteCarloPiParallel.calculatePi(numThreads, numSimulations);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            totalTime += elapsedTime;
        }

        return totalTime / (double) numExperiments;
    }

    private static double calculatePiSingleThread(long numSimulations) {
        return MonteCarloPiParallel.calculatePi(1, numSimulations);
    }

    public static void main(String[] args) {
        final List<Integer> ITERATIONS = List.of(10_000_000, 100_000_000, 1_000_000_000);

        System.out.printf("%-15s %-15s %-6s\n", "Value", "Difference", "Time");

        double[] timesSeq = new double[ITERATIONS.size()];

        for (int i = 0; i < ITERATIONS.size(); ++i) {
            int iters = ITERATIONS.get(i);
            long nanos1 = System.nanoTime();
            double res = MonteCarloPi.calculatePi(iters);
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

        for (int iter : ITERATIONS) {
            double pi = calculatePiSingleThread(iter);
            double error = Math.abs(Math.PI - pi);
            System.out.println("Погрешность для " + iter + " симуляций: " + error);
        }
    }
}
