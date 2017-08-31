package crud.dao;

import crud.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoImplTest {

    @Autowired
    private ProductDao productDao;

    @Test
    @Transactional
    @Rollback
    public void deleteProduct() throws Exception {
        productDao.deleteProduct(2);
        assertEquals(1, productDao.listProducts().size());
    }

    @Test
    @Transactional
    @Rollback
    public void addProduct() throws Exception {
        productDao.addProduct(productExample());
        assertEquals(3, productDao.listProducts().size());
    }

    @Test
    @Transactional
    public void listProducts() throws Exception {
        assertEquals(2, productDao.listProducts().size());
    }

    @Test
    @Transactional
    @Rollback
    public void updateProduct() throws Exception {
        Product product = productExample();

        productDao.addProduct(product);

        product.setTitle("newTitle");

        productDao.updateProduct(product);

        assertEquals(product.getTitle(), productDao.findProductById(3).getTitle());
    }

    @Test
    @Transactional
    public void findProductById() throws Exception {
        assertEquals("test", productDao.findProductById(2).getTitle());
    }

    public Product productExample(){
        Product product = new Product();
        product.setTitle("title");
        product.setProducer("pro");
        product.setPrice(999d);
        product.setDescription("description");
        return product;
    }
}