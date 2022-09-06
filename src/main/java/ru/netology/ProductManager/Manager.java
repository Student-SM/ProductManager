package ru.netology.ProductManager;

public class Manager {
    protected Repository repository;

    public Manager(Repository repository) { //конструктор
        this.repository = repository;
    }
    public void add(Product product) { //метод добавления
        repository.add(product);
    }
    public void removeById(int id) { //метод удаления по id
      repository.remoteById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];  // "добавляем в конец" массива result продукт product
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
