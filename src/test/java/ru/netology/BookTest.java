package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void getAuthor() {
        Book book = new Book(11, "Book I", 100, "Author I");

        String expected = "Author I";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setAuthor() {
        Book book = new Book(11, "Book I", 100, "Author I");

        book.setAuthor("Author II");
        String expected = "Author II";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }
}