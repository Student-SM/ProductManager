package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {


    Repository repo = new Repository();//создаем репозиторий
    Manager manager = new Manager(repo);//создаем менеджер

    Book book1 = new Book(1, "Один", 111, "Первый");
    Book book2 = new Book(2, "Два", 222, "Второй");
    Smartphone smartphone1 = new Smartphone(3, "Один", 11111, "Первый");
    Smartphone smartphone2 = new Smartphone(4, "Второй", 22222, "Второй");

    @BeforeEach
    public void setup() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void nameMatches2() {//метод совпадения по имени в двух товарах

        Product[] actual = manager.searchBy("Один");
        Product[] expected = {book1, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nameMatches1() {//метод совпадения по имени в одном товаре

        Product[] actual = manager.searchBy("Второй");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nameDoesNotMatch() {//когда имя не соответствует

        Product[] actual = manager.searchBy("Третий");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findAll() { // возврат всех товаров добавленных в массив в порядке добавления

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() { //удаление продукта по Id

        manager.removeById(3);

        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notMatchTheProduct() {//не соответствует товару product запросу search

        boolean expected = false;
        boolean actual = manager.matches(book1, "Пятый");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void goodsCorrespond() {//товар соответствует product запросу search

        boolean expected = true;
        boolean actual = manager.matches(smartphone2, "Второй");

        Assertions.assertEquals(expected, actual);
    }

}
