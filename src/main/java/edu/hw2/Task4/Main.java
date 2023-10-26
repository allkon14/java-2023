package edu.hw2.Task4;

public class Main {
    public static void main(String[] args) {
        CallingInfo callingInfo = Task4.callingInfo(new Throwable());
        System.out.println(callingInfo);
    }
}
