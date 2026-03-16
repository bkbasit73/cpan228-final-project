package ca.humber.group2.cpan228finalproject.config.config;

import ca.humber.group2.cpan228finalproject.model.Role;
import ca.humber.group2.cpan228finalproject.model.User;
import ca.humber.group2.cpan228finalproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        User admin = userRepository.findByUsername("admin").orElse(null);

        if (admin == null) {
            admin = new User(
                    "Admin",
                    "User",
                    "admin@test.com",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    Role.ADMIN
            );
        } else {
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
            admin.setEnabled(true);
            admin.setEmail("admin@test.com");
        }

        userRepository.save(admin);
    }
}