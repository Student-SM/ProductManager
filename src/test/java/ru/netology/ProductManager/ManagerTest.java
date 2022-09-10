package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {


    Repository repo = new Repository();//создаем репозиторий
    Manager manager = new Manager(repo);//создаем менеджер

    Book book1 = new Book(1, "Один", 111, "Первый");
    Book book2 = new Book(2, "Два", 222, "Второй");
    Smartphone smartphone1 = new Smartphone(4, "Один", 11111, "Первый");
    Smartphone smartphone2 = new Smartphone(5, "Два", 22222, "Второй");

    @BeforeEach
    public void setup() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void nameMatches() {//метод совпадения по имени

        Product[] actual = manager.searchBy("Один");
        Product[] expected = {book1, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nameDoesNotMatch() {//когда имя не соответствует

        Product[] actual = manager.searchBy("Третий");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }
}
