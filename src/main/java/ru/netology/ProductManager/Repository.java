package ru.netology.ProductManager;

public class Repository {
    protected Product[] products = new Product[0]; //Массив для хранения товаров

    public void add(Product product) {  //Метод добавления товара
        Product[] tmp = new Product[products.length + 1];  //создаем новый массив на одну ячейку больше старого
        for (int i = 0; i < products.length; i++) {   // Копируем все из старого массива
            tmp[i] = products[i];

        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void remoteById(int id) {    //Метод удаления товара по ID
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;

    }

    public Product[] findAll() {    //Метод показать все товары.

        return products;
    }
}
