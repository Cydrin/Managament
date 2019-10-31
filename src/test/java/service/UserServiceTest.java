package service;

import api.UserService;
import org.junit.Assert;
import org.junit.Test;
import src.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(11L, "pablo", "123"));
        users.add(new User(22L, "janko", "556"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser(){
        List<User> users = new ArrayList<User>();
        User user = new User(5L, "anon", "obiad");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> resultList = userService.getAllUsers();

        Assert.assertEquals(users, resultList);
    }

    @Test
    public void testRemoveUser(){
        List<User> users = new ArrayList<User>();
        User admin = new User(1L, "admin", "admin");
        User pablo = new User(2L, "pablo", "123");
        users.add(admin);
        users.add(pablo);

        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(1L);
        users.remove(admin);
        List<User> resultList = userService.getAllUsers();

        Assert.assertEquals(users, resultList);

    }
}
