package DAO;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private EntityManager manager;


    @Override
    public void addUser(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list =  manager.createQuery("SELECT user FROM User user", User.class).getResultList();
        return list;
    }

    @Override
    public User getUser(long id){
       User user = manager.find(User.class, new Long(id));
       manager.detach(user);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void updateUser(User user) {
        manager.detach(user);
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
    }
}
