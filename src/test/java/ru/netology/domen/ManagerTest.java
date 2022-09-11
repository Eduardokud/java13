package ru.netology.domen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {


    @Test
    public void removeById() {
        Book book1 = new Book(5, "первая", 100, "первый");
        Book book2 = new Book(15, "вторая", 200, "второй");
        Book book3 = new Book(25, "третья", 300, "третий");
        Smartphone smartphone1 = new Smartphone(27, "первый", 400, "высокая");

        Repository repo = new Repository();

        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.removeById(15);
        Product[] actual = manager.findAll();
        Product[] expected = {book1, book3, smartphone1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByfalseId() {
        Book book1 = new Book(5, "первая", 100, "первый");
        Book book2 = new Book(15, "вторая", 200, "второй");
        Book book3 = new Book(25, "третья", 300, "третий");
        Smartphone smartphone1 = new Smartphone(27, "первый", 400, "высокая");

        Repository repo = new Repository();

        Manager manager = new Manager(repo);
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.removeById(53);
        });

    }
}