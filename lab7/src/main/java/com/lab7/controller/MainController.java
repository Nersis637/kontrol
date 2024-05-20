package com.lab7.controller;

import com.lab7.QuestStatusEnum;
import com.lab7.entity.Quest;
import com.lab7.entity.User;
import com.lab7.entity.Users;
import com.lab7.repository.UserRepository;
import com.lab7.service.DatabaseService;
import com.lab7.service.DatabaseServiceQuestClass;
import com.lab7.service.DatabaseServiceUserClass;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    DatabaseServiceQuestClass service;
    @Autowired
    DatabaseServiceUserClass serviceUsers;



    @RequestMapping("/admin")
    public String admin(Model model, HttpSession session){
            List<Quest> questList = service.getList();
            model.addAttribute("quest", questList);
            return "admin";
    }
    @GetMapping("/createQuest")
    public String createQuest(Model model){
        model.addAttribute("quest",new Quest());
        model.addAttribute("options", QuestStatusEnum.values());
        return "createQuest";
    }
    @PostMapping("/createQuest")
    public String createQuest(@ModelAttribute Quest quest){
        service.create(quest);
        return "redirect:/admin";
    }
    @GetMapping("/updateQuest/{id}")
    public String updateQuest(@PathVariable int id, Model model){
        Quest quest = service.get(id);
        model.addAttribute("quest", quest);
        model.addAttribute("options", QuestStatusEnum.values());
        return "updateQuest";
    }
    @PostMapping("/updateQuest")
    public String updateQuest(@ModelAttribute Quest quest){
        service.update(quest);
        return "redirect:/admin";
    }
    @GetMapping("/deleteQuest/{id}")
    public String deleteQuest(@PathVariable int id){
        service.delete(id);
        return "redirect:/admin";
    }










    @RequestMapping("/user")
    public String user(Model model, HttpSession session){
            List<Users> userList=serviceUsers.getList();
            model.addAttribute("user", userList);
            return "user";
    }
    @GetMapping("/createUser")
    public String createUser(Model model){
        model.addAttribute("user",new Users());
        return "createUser";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute Users user){
        serviceUsers.create(user);
        return "redirect:/user";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, Model model){
        Users user = serviceUsers.get(id);
        model.addAttribute("user", user);
        return "updateUser";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute Users user){
        serviceUsers.update(user);
        return "redirect:/user";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        serviceUsers.delete(id);
        return "redirect:/user";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user) {
        databaseService.registration(user);
        return "redirect:/";
    }


}
