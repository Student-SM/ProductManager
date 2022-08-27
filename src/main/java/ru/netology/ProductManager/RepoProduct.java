package ru.netology.ProductManager;

public class RepoProduct {
    protected Product[] sku = new Product[0];
    public RepoProduct(){//конструктор

    }
    public void addSku(Product addSku) { //добавляем новые продукты

        Product[] tmp = new Product[sku.length + 1];// создаю временный массив с возможностью добавлять ячейки
        for (int i = 0; i < sku.length; i++) {
            tmp[i] = sku[i];

            tmp[sku.length] = addSku;
            sku = tmp;
        }
    }
    public Product[] findAll() { //выводим  все продукты
        return sku;
    }

    public void deleteById(int id) {//удаляем по id
        Product[] tmp = new Product[sku.length - 1];
        int index;
        index = 0;
        for (Product sku :sku) {
            if (Product.getId() != id) {
                tmp[index] = sku;
                index++;
            }
        }
            sku = tmp;
        }
    }







