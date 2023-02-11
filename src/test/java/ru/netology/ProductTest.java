package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getProductId() {
        Product product = new Product(1, "First", 100);

        int expected = 1;
        int actual = product.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setId() {
        Product product = new Product(1, "First", 100);

        product.setId(11);
        int expected = 11;
        int actual = product.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getName() {
        Product product = new Product(1, "First", 100);

        String expected = "First";
        String actual = product.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setName() {
        Product product = new Product(1, "First", 100);

        product.setName("Second");
        String expected = "Second";
        String actual = product.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPrice() {
        Product product = new Product(1, "First", 100);

        int expected = 100;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setPrice() {
        Product product = new Product(1, "First", 100);

        product.setPrice(200);
        int expected = 200;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

}