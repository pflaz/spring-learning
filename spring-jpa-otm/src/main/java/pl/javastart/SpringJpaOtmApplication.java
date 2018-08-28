package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.ClientDao;
import pl.javastart.dao.OrderDao;
import pl.javastart.model.Client;
import pl.javastart.model.Order;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

        Client client = new Client("firstname", "lastname", "address");
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);
        System.out.println(client);

        Order order = new Order("product", "details");
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        orderDao.save(order);

        Order retrievedOrder = orderDao.get(1L);
        System.out.println(retrievedOrder);

        Client retrievedClient = clientDao.get(1L);
        System.out.println(retrievedClient);

        ctx.close();
    }
}
