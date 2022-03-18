package DAO;

import models.User;

import java.util.List;

public interface UserDao {
     void addUser(User user);
     List<User> getAllUsers();
     User getUser(long id);
     void deleteUser(long id);
     void updateUser(User user);

}
