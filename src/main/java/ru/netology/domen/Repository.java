package ru.netology.domen;

public class Repository {
    protected Product[] products = new Product[0];

    public void add(Product item) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = item;
        products = tmp;
    }
    public Product findByid(int id) {
        for (Product product : products){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }
    public void removeById(int id) {
        if (findByid(id) == null) {
            throw new NotFoundException("нет товара с таким id" + id);
        }

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



}