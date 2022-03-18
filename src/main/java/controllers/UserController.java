package controllers;

import DAO.UserDaoImpl;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("user", new User());
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "users";
    }


    @PostMapping()
    public String addUser( User user){
      userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/addUser")
    public String newUser(User user ){
       // model.addAttribute("newuser", new User());
        return "addUser";
    }

    @GetMapping("/{id}")
    public String deleteUserID(@PathVariable("id") long id, Model  model){
     userService.deleteUser(id);
        return "redirect:/users";
    }





     /* @GetMapping("/{id}")
    public String getUserByID(@PathVariable("id") long id, Model model){
        model.addAttribute("list", userDao.getUser(id));
        return "index";
    }*/
}
