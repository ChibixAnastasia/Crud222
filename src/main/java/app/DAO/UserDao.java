package app.DAO;

import app.models.User;

import java.util.List;

public interface UserDao {
     void addUser(String name, int age);
     void addUser(User user);
     List<User> getAllUsers();
     User getUser(long id);
     void deleteUser(long id);
     void updateUser( User user);
     void updateUser(String name, int age, long id);
}
