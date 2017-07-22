package crud.dao;

import crud.model.Product;

import java.util.List;

/**
 * Created by Alexander on 22/07/2017.
 */
public interface ProductDao {

    void addProduct(Product product);

    List listProducts();

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    Product findProductById(Integer id);

}
