package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    List<Product> productList ;

    public ProductServiceImpl() {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Iphone",300));
        productList.add(new Product(2,"SS",400));
        productList.add(new Product(3,"XM",500));

    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId()==id){
                index =i;

            }

        }
        return index;
    }

    @Override
    public Product findById(int id) {
        for (Product product: productList
             ) {
            if(product.getId()==id)
                return product;
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int indexOf = findIndexById(id);
        productList.set(indexOf,product);

    }

    @Override
    public void delete(int id) {
        int indexOf = findIndexById(id);
        productList.remove(indexOf);
    }
}
