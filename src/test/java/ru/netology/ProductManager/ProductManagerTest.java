package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {

    RepoProduct product = new RepoProduct();
    ProductManager manager = new ProductManager(product);

    Product book1 = new Book(1, "Book1", 100, "author1");
    Product book2 = new Book(2, "Book2", 200, "author2");
    Product smartphone1 = new Smartphone(1, "smartphone1", 1000, "manufacturer1");
    Product smartphone2 = new Smartphone(2, "smartphone2", 2000, "manufacturer2");

    @Test
    public void AddAllProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] expected = {};//{book1, book2, smartphone1, smartphone2};
        Product[] actual = manager.add();

        Assertions.assertArrayEquals(expected, actual);
    }
}

