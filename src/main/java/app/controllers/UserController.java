package app.controllers;

import app.models.User;
import app.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/")
public class UserController {
    private UserServiceImpl userService;

    @Autowired(required = true)
    public void setUserService(UserServiceImpl service) {
        userService = service;
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @RequestMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @RequestMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @RequestMapping("/saveUser")
    public String save(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect: /admin";
    }

    @RequestMapping("/updateUser")
    public String update(@RequestParam("userIDinRequestParam") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "newUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
