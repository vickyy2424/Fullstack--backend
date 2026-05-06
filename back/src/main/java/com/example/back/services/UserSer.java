package com.example.back.services;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.back.entity.User;
import com.example.back.repository.UserRepo;

@Service
@RequiredArgsConstructor
public class UserSer {

    
    private final UserRepo repo;

    public User create(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User newUser) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPasswordHash(newUser.getPasswordHash());

        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
