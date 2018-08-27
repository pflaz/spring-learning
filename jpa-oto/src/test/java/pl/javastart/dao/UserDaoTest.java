package pl.javastart.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javastart.model.User;
import pl.javastart.model.UserDetails;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void save() {
        // Given
        User user = new User("username", "password", "email");
        UserDetails details = new UserDetails("firstname", "lastname", "address");
        user.setDetails(details);

        // When
        userDao.save(user);
        long insertedId = user.getId();;

        // Then
        User retrievedUser = userDao.get(insertedId);
        Assert.assertEquals(user, retrievedUser);
    }

    @Test
    public void get() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}