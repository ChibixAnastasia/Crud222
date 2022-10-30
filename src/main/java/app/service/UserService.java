package app.service;

import app.models.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface UserService {

    @Transactional
    void addUser(User user);
    @Transactional
    List<User> getAllUsers();
    @Transactional
    User getUser(long id);
    @Transactional
    void deleteUser(long id);
    @Transactional
    void updateUser( User user);
    @Transactional
    void updateUser( String name, int age, long id);


}
