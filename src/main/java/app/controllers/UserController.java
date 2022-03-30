package app.controllers;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    public void setUserService(UserService service) {
        userService = service;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/getUser";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        return "newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/updateUser")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/updateUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

   /* @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("list", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserByID(@PathVariable("id") long id, Model model){
        model.addAttribute("list", userService.getUser(id));
        return "index";
    }

    @PostMapping()
    public String create(@ModelAttribute("name") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", userService.getUser(id));
        return "users";
    }

    @GetMapping("/updateUser")
    public String updateUser(@PathVariable("id") long id, Model model ){
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("newuser", new User());
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserID(@PathVariable("id") long id){
     userService.deleteUser(id);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") long id) {
        userService.updateUser( user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/people";
    }*/






}
