// --- AuthController.java ---
package com.example.gestiontaches.controller;

import com.example.gestiontaches.dto.AuthRequest;
import com.example.gestiontaches.model.User;
import com.example.gestiontaches.security.JwtUtil;
import com.example.gestiontaches.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute AuthRequest authRequest) {
        userService.register(authRequest.getEmail(), authRequest.getPassword());
        return "redirect:/accueil";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthRequest authRequest, Model model) {
        var userOpt = userService.findByEmail(authRequest.getEmail());
        if (userOpt.isPresent() && userService.checkPassword(authRequest.getPassword(), userOpt.get().getPassword())) {
            String token = jwtUtil.generateToken(userOpt.get().getEmail());
            model.addAttribute("token", token);
            return "redirect:/accueil";
        }
        model.addAttribute("error", "Email ou mot de passe invalide");
        return "login";
    }
}

