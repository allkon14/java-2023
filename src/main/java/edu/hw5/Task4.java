package edu.hw5;

public class Task4 {
    public static boolean checkPassword(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
