package com.example.demo.parse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.atIndex;

public class ParseTests {
    @Test
    @DisplayName("Integer_parseInt: 형변환을 하기 위해서 Integer 클래스를 사용한다. ")
    void Integer_parseInt() {
        String num = "123";
        int i = Integer.parseInt(num);
        assertThat(i).isEqualTo(123);
    }

    @Test
    @DisplayName("String+int: 문자열과 숫자를 더하면 문자열이 된다.")
    void mergeStringInt() {
        String str = "";
        str += 3;
        assertThat(str).isEqualTo("3");
        assertThat(str).isNotEqualTo(3);
    }

    @Test
    @DisplayName("String.valueOf")
    void StringValueOf() {
        int i = 3;
        String str = String.valueOf(i);
        assertThat(str).isEqualTo("3");
        assertThat(str).isNotEqualTo(3);
    }

    @Test
    @DisplayName("Double_casting")
    void Double_casting() {
        double d = 3.14;
        int i = (int) d;
        assertThat(i).isEqualTo(3);

        int i2 = 3;
        double d2 = i2; // 정수를 실수로 바꿀 떄에는 캐스팅이 필요 없다.
        assertThat(d2).isEqualTo(3.0);
    }

    @Test
    @DisplayName("parseNotInteger")
    void parseNotInteger() {
        String str = "abc";
        String str2 = "123.44";

        try {
            int i = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println("str1 NumberFormatException 발생");
        }

        try {
            int i = Integer.parseInt(str2);
        } catch(NumberFormatException e) {
            System.out.println("str2 NumberFormatException 발생");
        }
    }
}
