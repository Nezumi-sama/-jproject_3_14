package ru.netology.domain;

public class Repository {
    private Product[] basket = new Product[0];

    public Product[] findAll() {
        return basket;
    }

    public void save(Product item) {
        Product[] tmp = new Product[basket.length + 1];

        if (basket.length == 0) {
            tmp[0] = item;
        } else {
            for (int i = 0; i < basket.length; i++) {
                tmp[i] = basket[i];
            }
            tmp[tmp.length - 1] = item;
        }
        basket = tmp;
    }

    public Product findById(int id) {
        //    Product element = null;

        for (Product item : basket) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Product[] tmp = new Product[basket.length - 1];
        int number = 0;

        for (int i = 0; i < basket.length; i++) {
            if (basket[i].getId() != id) {
                tmp[number] = basket[i];
                number++;
            }
        }
        basket = tmp;
    }

}
