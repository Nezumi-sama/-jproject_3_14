package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Product prod1 = new Product(1, "name1", 100);
    Product prod2 = new Product(2, "name2", 200);
    Product prod3 = new Product(3, "name123", 300);
    Product prod4 = new Product(4, "name14", 400);
    Product prod5 = new Product(5, "name5", 500);


    @Test
    void addItemFirstItem() {
        manager.addItem(prod4);

        Product[] expected = {prod4};
        Product[] actual = manager.getAllItems();

    }

    @Test
    void addItemNoFirstItem() {
        manager.addItem(prod4);
        manager.addItem(prod2);
        manager.addItem(prod1);

        Product[] expected = {prod4, prod2, prod1};
        Product[] actual = manager.getAllItems();

    }

    @Test
    void matchesThereIs() {

        boolean expected = true;
        boolean actual = manager.matches(prod1, "nam");

        assertEquals(expected, actual);

    }

    @Test
    void matchesThereIsNot() {

        boolean expected = false;
        boolean actual = manager.matches(prod1, "nam5");

        assertEquals(expected, actual);

    }


    @Test
    void searchBySevral() {
        manager.addItem(prod1);
        manager.addItem(prod2);
        manager.addItem(prod3);
        manager.addItem(prod4);
        manager.addItem(prod5);

        Product[] expected = {prod1, prod3, prod4};
        Product[] actual = manager.searchBy("name1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOne() {
        manager.addItem(prod1);
        manager.addItem(prod2);
        manager.addItem(prod3);
        manager.addItem(prod4);
        manager.addItem(prod5);

        Product[] expected = {prod2};
        Product[] actual = manager.searchBy("name2");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNoltOne() {
        manager.addItem(prod1);
        manager.addItem(prod2);
        manager.addItem(prod3);
        manager.addItem(prod4);
        manager.addItem(prod5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("name6");

        assertArrayEquals(expected, actual);
    }
/*

    @Test
    void findByIdThereIs() {
        manager.addItem(prod1);
        manager.addItem(prod2);
        manager.addItem(prod3);
        manager.addItem(prod4);
        manager.addItem(prod5);

        Product expected = prod3;
        Product actual = manager.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void findByIdThereIsNot() {
        manager.addItem(prod1);
        manager.addItem(prod2);
        manager.addItem(prod3);
        manager.addItem(prod4);
        manager.addItem(prod5);

        Product expected = null;
        Product actual = manager.findById(6);

        assertEquals(expected, actual);
    }*/

}