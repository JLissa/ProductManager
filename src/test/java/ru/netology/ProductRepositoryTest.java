package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Product product1 = new Product(1, "Product I", 100);
    Product product2 = new Book(2, "Book II", 200, "Author II");
    Product product3 = new Smartphone(3, "Smartphone III", 300, "Apple III");

    @Test
    void saveProductTest() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.findAllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findExistProductById() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);

        Product expected = product2;
        Product actual = repository.findProductById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void notExistProductById() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);

        Product expected = null;
        Product actual = repository.findProductById(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeExistProductById() throws NotFoundExeption {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);

        repository.removeProductById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeNotExistProductById() throws NotFoundExeption {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);

        Product expected = null;
        Product actual = repository.findProductById(4);

        Assertions.assertEquals(expected, actual);
//        Assertions.assertThrows(NotFoundExeption.class, () -> repository.removeProductById(4));
    }

    @Test
    void checkNotExistProductById() throws NotFoundExeption {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);

        Assertions.assertThrows(NotFoundExeption.class, () -> repository.removeProductById(4));
    }
}