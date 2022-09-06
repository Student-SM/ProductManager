package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void test() {
        Repository repo = new Repository();//создаем репозиторий
        Manager manager = new Manager(repo);//создаем менеджер

        Book book1 = new Book(1,"Первая",111,"ПервыйАвтор");
        Book book2 = new Book(2,"Вторая",222,"ВторойАвтор");
        Book book3 = new Book(3,"Третья",333,"ТретийАвтор");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Первая");
        Product[] expected = { book1 };

        Assertions.assertArrayEquals(expected,actual);

    }
}
