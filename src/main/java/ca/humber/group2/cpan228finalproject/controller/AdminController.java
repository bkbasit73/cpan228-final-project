package ca.humber.group2.cpan228finalproject.controller;

import ca.humber.group2.cpan228finalproject.model.Role;
import ca.humber.group2.cpan228finalproject.model.User;
import ca.humber.group2.cpan228finalproject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin-user";
    }

    @GetMapping("/admin/create-user")
    public String createUserForm(Model model) {
        model.addAttribute("roles", Role.values());
        return "create-user";
    }

    @PostMapping("/admin/create-user")
    public String createUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Role role
    ) {
        User user = new User(
                firstName,
                lastName,
                email,
                username,
                passwordEncoder.encode(password),
                role
        );

        user.setEnabled(true);
        userRepository.save(user);

        return "redirect:/admin";
    }

    @PostMapping("/admin/update-role")
    public String updateRole(@RequestParam Long id, @RequestParam Role role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setRole(role);
        userRepository.save(user);

        return "redirect:/admin";
    }

    @PostMapping("/admin/toggle-status")
    public String toggleStatus(@RequestParam Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setEnabled(!user.isEnabled());
        userRepository.save(user);

        return "redirect:/admin";
    }

    @PostMapping("/admin/delete-user")
    public String deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin";
    }
}