package test;

import main.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUserFirstName() {
        User u=new User();
        assertNull(u.getUserFirstName());
    }

    @Test
    void setUserFirstName() {
        User u=new User();
        u.setUserFirstName("Amit");
        assertEquals("Amit",u.getUserFirstName());
    }

    @Test
    void getUserLastName() {
        User u=new User();
        assertNull(u.getUserLastName());
    }

    @Test
    void setUserLastName() {
        User u=new User();
        u.setUserLastName("Shah");
        assertEquals("Shah",u.getUserLastName());
    }

    @Test
    void getUserEmail() {
        User u=new User();
        assertNull(u.getUserEmail());
        u.setUserEmail("amit.shah@gmail.com");
        assertEquals("amit.shah@gmail.com",u.getUserEmail());
    }

    @Test
    void setUserEmail() {
        User u=new User();
        u.setUserEmail("amit.shah@gmail.com");
        assertEquals("amit.shah@gmail.com",u.getUserEmail());
    }
}