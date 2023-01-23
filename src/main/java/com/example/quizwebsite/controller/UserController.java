package com.example.quizwebsite.controller;

import com.example.quizwebsite.domain.User;
import com.example.quizwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("about")
    public String about() {
        return "aboutus";
    }

    @GetMapping("signin")
    public String signin(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @GetMapping("signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("signin")
    public String signin(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model) {
        Optional<User> possibleUser = userService.validateLogin(username, password);
        if(possibleUser.isPresent()) {
            HttpSession oldSession = request.getSession(false);
            // invalidate old session if it exists
            if (oldSession != null) oldSession.invalidate();

            // generate new session
            HttpSession newSession = request.getSession(true);

            // store user details in session
            newSession.setAttribute("user", possibleUser.get());

            return "redirect:/";
        }
        else {
            return "signin";
        }
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute("user") User user) {
        try {
            user.setActive(true);
            userService.addUser(user);
            return "redirect:/signin";
        } catch (Exception e) {
            return "redirect:/signup";
        }
    }

    @GetMapping("/signout")
    public String signout(HttpServletRequest request, Model model) {
        HttpSession oldSession = request.getSession(false);
        // invalidate old session if it exists
        if(oldSession != null) oldSession.invalidate();
        return "redirect:/signin";
    }
}
