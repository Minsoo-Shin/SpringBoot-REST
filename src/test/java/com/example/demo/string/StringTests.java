package com.example.demo.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTests {
    @Test
    @DisplayName("String 클래스")
    public void createString() {

        // String 클래스는 내부 immutable하기 때문에 concat시 다른 객체가 생성된다.
        String str1 = "test";
        int i1 = str1.hashCode();
        str1 = "t";
        int i2 = str1.hashCode();
        assertThat(i2).isNotEqualTo(i1);

        String str2 = "test2";
        String str3 = "test3";
        String str23 = str2+str3;
        assertThat(str23).isEqualTo("test2test3");

        // 문자열 인스턴스에 int 추가
        String str4 = "";
        str4 += 0;
        str4 += 1;
        str4 += 2;
        assertThat(str4).isEqualTo("012");

        // 문자열 인스턴스에 for loop를 돌면서 문자열 추가하면 새로운 객체가 생성되기 때문에 성능을 고려해야한다.
        String str5 = "123";
        for (int i = 0; i < 2; ++i) {
            str5 = str5 + "456";
        }
        assertThat(str5).isEqualTo("123456456");

        // 문자열 인스턴스에 bool 추가
        String str6 = "" + true;
        assertThat(str6).isEqualTo("true");
    }

    @Test
    @DisplayName("String 클래스_문자열 비교")
    void String_문자열_비교() {
        String a = "hello";
        String b = "java";
        String c = "hello";
        assertThat(a.equals(b)).isFalse();
        assertThat(a.equals(c)).isTrue();
    }

    @Test
    @DisplayName("String_indexOf")
    void String_indexOf() {
        String str = "Hello, world!";
        int index = str.indexOf("world");
        assertThat(index).isEqualTo(7);
    }

    @Test
    @DisplayName("String_contains")
    void String_contains() {
        String str = "Hello, world!";
        boolean b = str.contains(",");
        assertThat(b).isEqualTo(true);
    }

    @Test
    @DisplayName("String_charAt")
    void String_charAt() {
        String str = "Hello, world!";
        char c = str.charAt(7);
        assertThat(c).isEqualTo('w');
    }

    @Test
    @DisplayName("String_substring")
    void String_substring() {
        String str = "Hello, world!";
        String s = str.substring(7);
        assertThat(s).isEqualTo("world!");
    }

    @Test
    @DisplayName("String_split")
    void String_split() {
        String a = "hello,java,world";
        String[] arr = a.split(",");
        assertThat(arr.length).isEqualTo(3);
    }

    @Test
    @DisplayName("String_formatting")
    void String_formatting() {
        System.out.println(String.format("%10s %10d %10.1f", "hello", 10, 3.14)); // %10.1: 10자리 확보 후 소수점 1자리까지 출력
        System.out.println(String.format("%10s",3.14)); // %10s: 10자리 확보 후 문자열 출력
    }
    @Test
    void createStringBuilder() {
        // StringBuilder는 mutable하기 때문에 concat시 같은 객체에 추가된다.
        StringBuilder sb1 = new StringBuilder("test");
        int i1 = sb1.hashCode();
        sb1.append("t");
        int i2 = sb1.hashCode();
        assertThat(i2).isEqualTo(i1);

        StringBuilder sb2 = new StringBuilder("test2");
        StringBuilder sb3 = new StringBuilder("test3");
        sb2.append(sb3);
        assertThat(sb2.toString()).isEqualTo("test2test3");

        // StringBuilder 인스턴스에 int 추가
        StringBuilder sb4 = new StringBuilder();
        sb4.append(0);
        sb4.append(1);
        sb4.append(2);
        assertThat(sb4.toString()).isEqualTo("012");

        // StringBuilder 인스턴스에 for loop를 돌면서 문자열 추가해도 같은 객체에 append 된다.
        StringBuilder sb5 = new StringBuilder("123");
        int i3 = sb5.hashCode();
        for (int i = 0; i < 2; ++i) {
            sb5.append("456");
        }
        int i4 = sb5.hashCode();
        assertThat(i4).isEqualTo(i3);

        // StringBuilder 인스턴스에 bool 추가
        StringBuilder sb6 = new StringBuilder();
        sb6.append(true);
        assertThat(sb6.toString()).isEqualTo("true");

        String s = "abcdefg";
        StringBuilder sb = new StringBuilder(s); // String -> StringBuilder

        System.out.println("처음 상태 : " + sb); //처음상태 : abcdefg
        System.out.println("문자열 String 변환 : " + sb.toString()); //String 변환하기
        System.out.println("문자열 추출 : " + sb.substring(2,4)); //문자열 추출하기
        System.out.println("문자열 추가 : " + sb.insert(2,"추가")); //문자열 추가하기
        System.out.println("문자열 삭제 : " + sb.delete(2,4)); //문자열 삭제하기
        System.out.println("문자열 연결 : " + sb.append("hijk")); //문자열 붙이기
        System.out.println("문자열의 길이 : " + sb.length()); //문자열의 길이구하기
        System.out.println("용량의 크기 : " + sb.capacity()); //용량의 크기 구하기
        System.out.println("문자열 역순 변경 : " + sb.reverse()); //문자열 뒤집기
        System.out.println("마지막 상태 : " + sb); //마지막상태 : kjihgfedcba
    }

    @Test
    @DisplayName("StringBuffer 클래스")
    void StringBuffer() throws InterruptedException {
        // StringBuffer는 mutable하기 때문에 concat시 같은 객체에 추가된다.
        StringBuffer sb1 = new StringBuffer("test");
        int i1 = sb1.hashCode();
        sb1.append("t");
        int i2 = sb1.hashCode();
        assertThat(i1).isEqualTo(i2);

        StringBuffer sb2 = new StringBuffer("test2");
        StringBuffer sb3 = new StringBuffer("test3");
        sb2.append(sb3);
        assertThat(sb2.toString()).isEqualTo("test2test3");

        // StringBuffer 인스턴스에 int 추가
        StringBuffer sb4 = new StringBuffer();
        sb4.append(0);
        sb4.append(1);
        sb4.append(2);
        assertThat(sb4.toString()).isEqualTo("012");

        // StringBuffer 인스턴스에 for loop를 돌면서 문자열 추가
        StringBuffer sb5 = new StringBuffer("123");
        for (int i = 0; i < 2; ++i) {
            sb5.append("456");
        }
        assertThat(sb5.toString()).isEqualTo("123456456");

        // StringBuffer 인스턴스에 bool 추가
        StringBuffer sb6 = new StringBuffer();
        sb6.append(true);
        assertThat(sb6.toString()).isEqualTo("true");

        // StringBuffer는 thread-safe하기 때문에 멀티스레드 환경에서 사용할 때 유용하다.
        StringBuffer sb7 = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            final int finalI = i;
            new Thread(() -> {
                sb7.append(finalI);
            }).start();
        }
        // Wait for all threads to finish
        Thread.sleep(1000);
        assertThat(sb7.length()).isEqualTo(10);


        String s = "abcdefg";
        StringBuffer sb = new StringBuffer(s); // String -> StringBuffer

        System.out.println("처음 상태 : " + sb); //처음상태 : abcdefg
        System.out.println("문자열 String 변환 : " + sb.toString()); //String 변환하기
        System.out.println("문자열 추출 : " + sb.substring(2,4)); //문자열 추출하기
        System.out.println("문자열 추가 : " + sb.insert(2,"추가")); //문자열 추가하기
        System.out.println("문자열 삭제 : " + sb.delete(2,4)); //문자열 삭제하기
        System.out.println("문자열 연결 : " + sb.append("hijk")); //문자열 붙이기
        System.out.println("문자열의 길이 : " + sb.length()); //문자열의 길이구하기
        System.out.println("용량의 크기 : " + sb.capacity()); //용량의 크기 구하기
        System.out.println("문자열 역순 변경 : " + sb.reverse()); //문자열 뒤집기
        System.out.println("마지막 상태 : " + sb); //마지막상태 : kjihgfedcba
    }
}