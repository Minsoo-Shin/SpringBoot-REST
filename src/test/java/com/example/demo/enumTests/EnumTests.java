package com.example.demo.enumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTests {
    enum CoffeeType {
        AMERICANO, LATTE, MOCHA
    };

    @Test
    @DisplayName("Enum_1")
    void Enum_1() {
        System.out.println("Sample.CoffeeType.AMERICANO = " + CoffeeType.AMERICANO);
        System.out.println("Sample.CoffeeType.LATTE = " + CoffeeType.LATTE);
        System.out.println("Sample.CoffeeType.MOCHA = " + CoffeeType.MOCHA);
        
        System.out.println("Sample.CoffeeType.AMERICANO.ordinal() = " + CoffeeType.AMERICANO.ordinal());
        System.out.println("Sample.CoffeeType.LATTE.ordinal() = " + CoffeeType.LATTE.ordinal());    
        System.out.println("Sample.CoffeeType.MOCHA.ordinal() = " + CoffeeType.MOCHA.ordinal());

        for (CoffeeType coffeeType : CoffeeType.values()) {
            System.out.println("coffeeType = " + coffeeType);
        }
    }
}
