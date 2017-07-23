package crud.service;

import crud.model.Product;

import java.util.List;

/**
 * Created by Alexander on 23/07/2017.
 */
public interface ProductService {

    void addProduct(Product product);

    List<Product> listProducts();

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    Product findProductById(Integer id);
}
