package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.model.Client;
import pl.javastart.model.Order;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

    public void removeAllOrders(Client client) {
        Client managedClient = get(client.getId());
        for (Order order: managedClient.getOrders())
            order.setClient(null);
        managedClient.getOrders().clear();
    }
}
