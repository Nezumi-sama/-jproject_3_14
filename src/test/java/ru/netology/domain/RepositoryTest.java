package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product prod1 = new Product(1, "name1", 100);
    Product prod2 = new Product(2, "name2", 200);
    Product prod3 = new Product(3, "name3", 300);
    Product prod4 = new Product(4, "name4", 400);
    Product prod5 = new Product(5, "name5", 500);

    @Test
    void findAll() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);

        Product[] expected = {prod1, prod2, prod3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveFirstItem() {
        Repository repo = new Repository();
        repo.save(prod1);

        Product[] expected = {prod1};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveNoFirstItem() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);
        repo.save(prod4);
        repo.save(prod5);

        Product[] expected = {prod1, prod2, prod3, prod4, prod5};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveItemWithDuplicateNumber() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);
        repo.save(prod4);
        repo.save(prod5);

        assertThrows(AlreadyExistsException.class, () -> {
            repo.save(prod3);
        });

    }


    @Test
    void findByIdThereIs() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);
        repo.save(prod4);
        repo.save(prod5);

        Product expected = prod3;
        Product actual = repo.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void findByIdThereIsNot() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);
        repo.save(prod4);
        repo.save(prod5);

        Product expected = null;
        Product actual = repo.findById(6);

        assertEquals(expected, actual);
    }


    @Test
    void removeByIdThereIs() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);
        repo.save(prod4);
        repo.save(prod5);

        repo.removeById(3);

        Product[] expected = {prod1, prod2, prod4, prod5};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void removeByIdThereIsNot() {
        Repository repo = new Repository();
        repo.save(prod1);
        repo.save(prod2);
        repo.save(prod3);
        repo.save(prod4);
        repo.save(prod5);


        assertThrows(NotFoundException.class, () -> {
            repo.removeById(6);
        });

    }


}