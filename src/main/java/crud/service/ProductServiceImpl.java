package crud.service;

import crud.dao.ProductDao;
import crud.model.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alexander on 23/07/2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    @Transactional
    public List<Product> listProducts() {
        return productDao.listProducts();
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        productDao.deleteProduct(id);
    }

    @Override
    @Transactional
    public Product findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
