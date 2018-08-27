package pl.javastart.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javastart.model.User;
import pl.javastart.model.UserDetails;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Test
    public void get() {

        // Given
        User user = new User("username", "pass", "mail");
        UserDetails userDetails = new UserDetails("firstname", "lastname", "address");

        user.setDetails(userDetails);
        userDao.save(user);
        long insertedUserDetailsId = user.getDetails().getId();

        // When
        UserDetails retrievedUserDetails = userDetailsDao.get(insertedUserDetailsId);


        // Then
        Assert.assertEquals(userDetails.getFirstName(), retrievedUserDetails.getFirstName());
        Assert.assertEquals(userDetails.getLastName(), retrievedUserDetails.getLastName());
        Assert.assertEquals(userDetails.getAddress(), retrievedUserDetails.getAddress());
        Assert.assertEquals(user, retrievedUserDetails.getUser());
    }
}