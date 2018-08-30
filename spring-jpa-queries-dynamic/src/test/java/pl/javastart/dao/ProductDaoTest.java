package pl.javastart.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javastart.model.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Before
    public void prepareProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("product 1", "producer 1", 1.11));
        products.add(new Product("product 2", "producer 2", 2.22));
        products.add(new Product("product 3", "producer 3", 3.33));
        products.add(new Product("product 4", "producer 4", 4.44));
        products.add(new Product("product 5", "producer 5", 5.55));

        products.forEach(productDao::save);
    }

    @After
    public void removeAll() {
        productDao.deleteAll();
    }

    @Test
    public void get() {
        // Given
        Product testProduct = new Product("product test", "producer test", 500.0);
        productDao.save(testProduct);
        long insertedId = testProduct.getId();

        // When
        Product retrievedProduct = productDao.get(insertedId);
        System.out.println(retrievedProduct);

        // Then
        Assert.assertEquals(testProduct, retrievedProduct);
    }


    @Test
    public void getAll() {
        // Given

        // When
        int quantity = productDao.getAll().size();

        // Then
        Assert.assertEquals(5, quantity);

    }

    @Test
    public void deleteAll() {
        // Given

        // When
        productDao.deleteAll();
        int quantity = productDao.getAll().size();

        // Then
        Assert.assertEquals(0, quantity);
    }

    @Test
    public void customGet() {
        // Given
        final String query = "SELECT p FROM Product p WHERE p.price > 3";


        // When
        int quantity = productDao.customGet(query).size();
        // Then
        Assert.assertEquals(3, quantity);
    }
}