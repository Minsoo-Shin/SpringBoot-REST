package com.example.demo.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArrayListTests {
    @Test
    @DisplayName("ArrayList_add")
    void ArrayList_add() {
        ArrayList<String> arrList = new ArrayList();

        arrList.add("1");
        arrList.add("2");

        assertThat(arrList.get(0)).isEqualTo("1");
        assertThat(arrList.get(1)).isEqualTo("2");

        arrList.add(1, "1.5");
        assertThat(arrList.get(1)).isEqualTo("1.5");

        System.out.println("arrList = " + arrList);
    }

    @Test
    @DisplayName("ArrayList_remove")
    void ArrayList_remove() {
        ArrayList<String> arrList = new ArrayList();

        arrList.add("1");
        arrList.add("2");
        arrList.add("3");

        arrList.remove(1);
        assertThat(arrList.get(1)).isEqualTo("3");

        System.out.println("arrList = " + arrList);
    }

    @Test
    @DisplayName("ArrayList_join")
    void ArrayList_join() {
        ArrayList<String> arrList1 = new ArrayList();

        arrList1.add("1");
        arrList1.add("2");
        arrList1.add("3");

        assertThat(String.join(",", arrList1)).isEqualTo("1,2,3");
    }

    @Test
    @DisplayName("ArrayList_sort")
    void ArrayList_sort() {
        ArrayList<String> arrList = new ArrayList();

        arrList.add("3");
        arrList.add("1");
        arrList.add("2");
        arrList.sort(Comparator.reverseOrder());
        assertThat(String.join(",", arrList)).isEqualTo("3,2,1");

        arrList.sort(Comparator.naturalOrder());
        assertThat(String.join(",", arrList)).isEqualTo("1,2,3");
    }
}
