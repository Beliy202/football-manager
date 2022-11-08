package com.example.footballmanager.servise;

import com.example.footballmanager.entity.User;
import com.example.footballmanager.entity.enumUser.Role;
import com.example.footballmanager.exception.ResourceNotFoundException;
import com.example.footballmanager.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userService")

public class UserService implements UserDetailsService {
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jpaUserRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException(String.format("User not found by username %s", username)));
    }

    public User findByUsername(String username) {
        return jpaUserRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException(String.format("User not found by username %s", username)));
    }

    public void save(User user) {
        Set<Role> role = new HashSet<>();
        role.add(Role.USER);
        user.setRoles(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        jpaUserRepository.save(user);
    }

    public void saveAdmin() {
        User user = User.builder()
                .username("admin")
                .password("123")
                .name("denis")
                .build();
        Set<Role> role = new HashSet<>();
        role.add(Role.ADMIN);
        user.setRoles(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        jpaUserRepository.save(user);
    }

}
