package ru.netology.domain;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void addItem(Product item) {
        repo.save(item);
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        Repository tmp = new Repository();

        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                tmp.save(product);
                result = tmp.findAll();
            }
        }

        return result;

    }

    public Product[] getAllItems() {
        Product[] allItems = repo.findAll();
        return allItems;
    }
/*
    public Product findById(int id) {
        Product[] allItems = repo.findAll();

        for (Product item : allItems) {
            if (id == item.id) {
                return item;
            }
        }
        return null;
    }

    public void removeById (int id){


    }*/
/*

    public Product[] getLastItems() {
        Product[] allItems = repo.findAll();
        int count = 10;
        int number = 0;
        if (allItems.length < 10) {
            count = allItems.length;
        }
        Product[] lastItems = new Product[count];

        for (int i = allItems.length - 1; i > allItems.length - count - 1; i--) {
            lastItems[number] = allItems[i];
            number++;
        }

        return lastItems;
    }

    public Product[] getLastItems(int count) {
        Product[] allItems = repo.findAll();
        int number = 0;
        if (allItems.length < count) {
            count = allItems.length;
        }
        Product[] lastItems = new Product[count];

        for (int i = allItems.length - 1; i > allItems.length - count - 1; i--) {
            lastItems[number] = allItems[i];
            number++;
        }

        return lastItems;
    }
*/

}
