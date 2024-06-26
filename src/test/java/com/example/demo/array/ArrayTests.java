package com.example.demo.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTests {
    @Test
    @DisplayName("Array_선언하기")
    void Array_선언하기() {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = i + 1;
            System.out.printf("arr[%s] = %s\n", i, arr[i]);
        }
    }

    @Test
    @DisplayName("Array_접근하기")
    void Array_접근하기() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    @DisplayName("Array_길이구하기")
    void Array_길이구하기() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr.length);
    }

    @Test
    @DisplayName("Array_IndexOutOfBound")
    void Array_IndexOutOfBound() {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException 발생");
        }
    }

    @Test
    @DisplayName("Array_sort")
    void Array_sort() {
        Integer[] arr = {3, 1, 4, 1};
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        Arrays.sort(arr, Collections.reverseOrder());
    }

    @Test
    @DisplayName("Array_subString")
    void Array_subString() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, 3)));
    }
}
