package ru.netology.ProductManager;


public class ProductManager {
    private final RepoProduct product;

    public ProductManager(RepoProduct repository) {
        this.product = repository;
    }

    public void add(Product addSku) {
        product.addSku(addSku);


    }
    // добавьте необходимые поля, конструкторы и методы

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : product.findAll()) {
            matches(product, text);
            //            if (matches(product, text)) {
//                // "добавляем в конец" массива result продукт product
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public void matches(Product product, String search) {

//        public boolean matches(Product product, String search) {
//            return product.getName().contains(search);

//        public boolean matches(Product product, String search) {
//            if (product.getName().contains(search)) {
//                return true;
//            } else {
//                return false;
//            }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Product[] add() {
        return product.findAll();
    }
}
