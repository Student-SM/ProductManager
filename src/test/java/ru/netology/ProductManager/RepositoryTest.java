package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Repository repo = new Repository();//создаем репозиторий

    Book book1 = new Book(1, "Один", 111, "Первый");
    Book book2 = new Book(2, "Два", 222, "Второй");
    Smartphone smartphone1 = new Smartphone(3, "Один", 11111, "Первый");
    Smartphone smartphone2 = new Smartphone(4, "Второй", 22222, "Второй");

    @BeforeEach
    public void setup() {

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);
    }

    @Test
    public void addProduct() {//добавление товара

        Product product = new Product(5, "Пятый", 555);
        repo.add(product);

        Product[] expected = new Product[]{
                book1,
                book2,
                smartphone1,
                smartphone2,
                product,
        };

        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test

    public void remoteById() {//удаление по ID (удаляем второй товар)

        repo.remoteById(2);

        Product[] expected = new Product[]{
                book1,
                smartphone1,
                smartphone2,
        };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
