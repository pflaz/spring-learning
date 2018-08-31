package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.ProductDao;
import pl.javastart.model.Product;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaQueriesStaticApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaQueriesStaticApplication.class, args);

        List<Product> products = new ArrayList<>();
        products.add(new Product("product 1", "producer 1", 1.11));
        products.add(new Product("product 2", "producer 2", 2.22));
        products.add(new Product("product 3", "producer 3", 3.33));
        products.add(new Product("product 4", "producer 4", 4.44));
        products.add(new Product("product 5", "producer 5", 5.55));

        ProductDao productDao = ctx.getBean(ProductDao.class);
        products.forEach(productDao::save);

        System.out.println("All products:");
        List<Product> allProducts = productDao.getAll();
        allProducts.forEach(System.out::println);

        System.out.println("Product more expensive than 3");
        List<Product> expensiveProducts = productDao.customGet("SELECT p FROM Product p WHERE p.price > 3");
        expensiveProducts.forEach(System.out::println);

        System.out.println("All products ordered by price:");
        List<Product> productsSorted = productDao.customGet("SELECT p from Product p ORDER BY p.price ASC");
        productsSorted.forEach(System.out::println);

        System.out.println("Products got by name:");
        List<Product> productsGotByName = productDao.getByName("product 3");
        productsGotByName.forEach(System.out::println);

        System.out.println("Delete by producer:");
        productDao.deleteByProducer("producer 4");
        List<Product> productsAfterDelete = productDao.getAll();
        productsAfterDelete.forEach(System.out::println);

        productDao.deleteAll();
        List<Product> productList = productDao.getAll();
        System.out.println("Products after delete: " + productList.size());

    }
}
