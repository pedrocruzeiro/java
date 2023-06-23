package org.example;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(calculateFactorial(5));
    }

    private static int calculateFactorial(int n){
        if (n == 0){
            return 1;
        }

    return n * calculateFactorial(n - 1);
    }
}
