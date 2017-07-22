package crud.dao;

import crud.model.Product;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexander on 22/07/2017.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;
    private Logger LOGGER;

    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
        LOGGER.info("Product successfully added");
    }

    @Override
    public List listProducts() {
        return sessionFactory.getCurrentSession().createQuery("select p from Product p").list();

    }

    @Override
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
        LOGGER.info("Product successfully updated");
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = sessionFactory.getCurrentSession().load(Product.class, id);

        if (product != null){
            sessionFactory.getCurrentSession().delete(product);
            LOGGER.info("Product successfully deleted");
        } else {
            LOGGER.info("Product not found!");
        }
    }

    @Override
    public Product findProductById(Integer id) {
        return sessionFactory.getCurrentSession().load(Product.class, new Integer(id));
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
