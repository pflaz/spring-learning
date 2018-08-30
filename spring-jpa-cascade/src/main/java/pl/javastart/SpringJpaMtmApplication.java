package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.ClientDao;
import pl.javastart.dao.OrderDao;
import pl.javastart.dao.ProductDao;
import pl.javastart.model.Client;
import pl.javastart.model.Order;
import pl.javastart.model.Product;

@SpringBootApplication
public class SpringJpaMtmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaMtmApplication.class, args);

        Client client = new Client("firstname", "lastname", "address");
        Order order = new Order("order details");
        Product product1 = new Product("product 1", 1.11, "det1");
        Product product2 = new Product("product 2", 2.22, "det2");
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        client.addOrder(order);
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);

        clientDao.removeAllOrders(client);

        Client retrievedClient = clientDao.get(1L);
        System.out.println(retrievedClient);

    }
}
