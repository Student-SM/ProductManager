package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void test() {//метод добавления
        Repository repo = new Repository();//создаем репозиторий
        Manager manager = new Manager(repo);//создаем менеджер

        Book book1 = new Book(1, "Первая", 111, "ПервыйАвтор");
        Book book2 = new Book(2, "Вторая", 222, "ВторойАвтор");
        Book book3 = new Book(3, "Третья", 333, "ТретийАвтор");
        Smartphone smartphone1 = new Smartphone(4, "Сотовый1", 11111, "Производитель1");
        Smartphone smartphone2 = new Smartphone(5, "Сотовый2", 22222, "Производитель2");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual = manager.searchBy("Сотовый2");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected,actual);
    }
}
