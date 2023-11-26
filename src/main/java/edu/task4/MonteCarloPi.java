package edu.task4;

import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloPi {
    private MonteCarloPi() {
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
}
