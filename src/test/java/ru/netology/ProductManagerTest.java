package ru.netology;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    Product product1 = new Product(1, "Product I", 100);
    Product product2 = new Book(2, "Book II", 200, "Author II");
    Product product3 = new Smartphone(3, "Smartphone III", 300, "Apple III");

    Product product4 = new Book(4, "Book IV", 400, "Author IV");


    @Test
    void addProductTest() {
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getAllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByExistTextTest() {
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Product I");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNotExistTextTest() {
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Product II");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByPartOfTextTest() {
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Smart");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchMultipliesExistByTextTest() {
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);

        Product[] expected = {product2, product4};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesExistTest() {
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        boolean expected = true;
        boolean actual = manager.matches(product2, "Book II");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void searchMatchesNotExistTest() {
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        boolean expected = false;
        boolean actual = manager.matches(product1, "Book");

        Assertions.assertEquals(expected, actual);

    }
}