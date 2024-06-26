package com.example.demo.oo;

public class ObjectOriented {
    class Calculator {
        static int result;

        public int add(int n) {
            result += n;
            return result;
        }
    }

    public void main(String[] args) {
        Calculator c1 = new Calculator();
        Calculator c2 = new Calculator();

        System.out.println(c1.add(1));
        System.out.println(c2.add(2));
    }
}
