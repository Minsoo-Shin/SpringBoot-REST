package com.example.demo.hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HashMapTests {
    @Test
    void hashMap_추가() {
        // hasMap 선언
        HashMap<String, String> sampleMap = new HashMap<>();
        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");

        assertThat(sampleMap.get("key1").equals("value1"));
        assertThat(sampleMap.get("key2").equals("value2"));
    }

    @Test
    void hashMap_같은키_덮어쓰기() {
        // hasMap 선언
        HashMap<String, String> sampleMap = new HashMap<>();
        sampleMap.put("sameKey", "value1");
        sampleMap.put("sameKey", "value2");

        assertThat(sampleMap.get("sameKey").equals("value2"));
    }

    @Test
    void hashMap_데이터_삭제하기() {
        // hasMap 선언
        HashMap<String, String> sampleMap = new HashMap<>();
        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");

        sampleMap.clear();

        assertThat(sampleMap.get("key1") == null);
        assertThat(sampleMap.get("key2") == null);

        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");

        sampleMap.remove("key1");

        assertThat(sampleMap.get("key1") == null);
        assertThat(sampleMap.get("key2").equals("value2"));
    }

    @Test
    void hashMap_데이터_수정하기() {
        HashMap<String, String> sampleMap = new HashMap<>();
        sampleMap.put("key1", "value1");

        sampleMap.replace("key1", "newValue1");

        assertThat(sampleMap.get("key1").equals("newValue1"));

        boolean exist = sampleMap.replace("key2", "value2", "newValue2");
        assertThat(exist).isEqualTo(false);

        sampleMap.put("key2", "value2");
        exist = sampleMap.replace("key2", "value2", "newValue2");
        assertThat(exist).isEqualTo(true);
        assertThat(sampleMap.get("key2").equals("newValue2"));
    }

    @Test
    @DisplayName("HashMap Key로 확인하기")
    void hashMap_데이터확인() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");

        assertThat(hashMap.containsKey("key1")).isEqualTo(true);
    }

    @Test
    @DisplayName("HashMap Value로 확인하기")
    void hashMap_데이터확인2() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");

        assertThat(hashMap.containsValue("value1")).isEqualTo(true);
    }

    @Test
    @DisplayName("HashMap 데이터가 빈 상태인지 확인하기")
    void hashMap_데이터확인3() {
        HashMap<String, String> hashMap = new HashMap<>();
        assertThat(hashMap.isEmpty()).isEqualTo(true);

        hashMap.put("key1", "value1");
        assertThat(hashMap.isEmpty()).isEqualTo(false);
    }

    @Test
    @DisplayName("HashMap 데이터 가져오기 get")
    void hashMap_데이터가져오기() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");

        assertThat(hashMap.get("key1").equals("value1"));
    }

    @Test
    @DisplayName("HashMap 데이터 가져오기 getOrDefault")
    void hashMap_데이터가져오기2() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");

        assertThat(hashMap.getOrDefault("key1", "defaultValue")).isEqualTo("value1");
        assertThat(hashMap.getOrDefault("key2", "defaultValue")).isEqualTo("defaultValue");

    }

    @Test
    @DisplayName("HashMap 데이터 가져오기 entrySet")
    void hashMap_데이터가져오기3() {
HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");

        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Set<String> keySet = hashMap.keySet();
        keySet.forEach(System.out::println);
    }

    @Test
    @DisplayName("HashMap 데이터 가져오기 values")
    void hashMap_데이터가져오기4() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");

        Collection<String> values = hashMap.values();
        values.forEach(System.out::println);
    }
}
