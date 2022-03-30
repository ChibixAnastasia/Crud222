package app.service;

import app.DAO.UserDaoImpl;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDaoImpl userDao;

    @Autowired
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(String name, int age) {
        this.userDao.addUser(name, age);
    }

    @Override
    @Transactional
    public void addUser(User user){
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();

    }

    @Override
    @Transactional
    public User getUser(long id) {
        return this.userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser( User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void updateUser(String name, int age, long id) {
        this.userDao.updateUser(name, age, id);
    }


}
