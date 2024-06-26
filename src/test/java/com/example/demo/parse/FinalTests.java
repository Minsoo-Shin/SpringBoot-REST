package com.example.demo.parse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FinalTests {
    @Test
    @DisplayName("final_자료형_값은_한번만_설정가능")
    void final_자료형_값은_한번만_설정가능() {
        final int a = 1;
        // a = 2; // 컴파일 에러
    }

    @Test
    @DisplayName("final_ArrayList_add_remove_가능")
    void final_ArrayList에서도_변경이_안됨() {
        final ArrayList<String> arrList = new ArrayList<>();
        arrList.add("1");
        arrList.add("2");

        assertThat(arrList.get(0)).isEqualTo("1");
        assertThat(arrList.get(1)).isEqualTo("2");

        arrList.remove("1");
        assertThat(arrList.get(0)).isEqualTo("2");
    }

    @Test
    @DisplayName("final_ArrayList_asList")
    void final_ArrayList_asList() {
        final ArrayList<String> arrList = new ArrayList<>();
        arrList.add("1");
        arrList.add("2");

        // arrList = new ArrayList<>(); // 컴파일 에러
    }
}
