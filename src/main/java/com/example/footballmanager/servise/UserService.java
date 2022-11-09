package com.example.footballmanager.servise;

import com.example.footballmanager.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUsername(String username);

    public void save(User user);

    public void saveAdmin();
}
