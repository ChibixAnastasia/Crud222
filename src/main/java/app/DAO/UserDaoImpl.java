package app.DAO;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private EntityManager manager;



    @Override
    public void addUser(User user){
        manager.persist(user);
    }
    @Override
    public List<User> getAllUsers() {
        List<User> list =  manager.createQuery("SELECT user FROM User user", User.class).getResultList();
        return list;
    }

    @Override
    public User getUser(long id){
       User user = manager.find(User.class, id);
       //manager.detach(user);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        User user = manager.find(User.class, id);
        manager.remove(user);


    }

    @Override
    public void updateUser( User user) {
       // manager.detach(user);
        manager.merge(user);
    }

    @Override
    public void updateUser(String name, int age, long id){
        User user = manager.find(User.class, id);
        user.setName(name);
        user.setAge(age);
        manager.merge(user);
    }
}
