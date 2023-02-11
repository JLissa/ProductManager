package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void getManufacturer() {
        Smartphone smartphone = new Smartphone(1, "Phone I", 100, "Apple I");

        String expected = "Apple I";
        String actual = smartphone.getManufacturer();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void setManufacturer() {
        Smartphone smartphone = new Smartphone(1, "Phone I", 100, "Apple I");

        smartphone.setManufacturer("Apple II");
        String expected = "Apple II";
        String actual = smartphone.getManufacturer();

        Assertions.assertEquals(expected, actual);
    }
}