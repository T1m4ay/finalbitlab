package com.example.finalproject.controller;

import com.example.finalproject.model.User;
import com.example.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String indexPage() {
        return "game";
    }

    @GetMapping(value = "/login-page")
    public String signInPage() {
        return "login";
    }

    @GetMapping(value = "/register-page")
    public String signupPage() {
        return "register";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDenied() {
        return "403";
    }

    @GetMapping(value = "/password-edit-page")
    public String updatePasswordPage() {
        return "password-edit";
    }

    @PostMapping(value = "/to-register")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/register-page?success";
            } else {
                return "redirect:/register-page?emailerror";
            }
        } else {
            return "redirect:/register-page?passworderror";
        }
    }

    @PostMapping(value = "/to-edit-password")
    public String toUpdatePassword(
            @RequestParam(name = "user_old_password") String oldPassword,
            @RequestParam(name = "user_new_password") String newPassword,
            @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

        if (newPassword.equals(repeatNewPassword)) {

            User user = userService.updatePassword(newPassword, oldPassword);
            if (user != null) {
                return "redirect:/password-edit-page?success";
            } else {
                return "redirect:/password-edit-page?oldpassworderror";
            }

        } else {
            return "redirect:/password-edit-page?passwordmismatch";
        }
    }

}
