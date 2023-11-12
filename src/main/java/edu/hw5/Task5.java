package edu.hw5;

public class Task5 {
    public static boolean isValidNumberPlate(String number) {
        return number.matches("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$");
    }
}
