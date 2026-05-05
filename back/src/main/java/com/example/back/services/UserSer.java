package com.example.back.services;



import com.back.entity.User;
import com.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSer {

    
    private final UserRepository repo;

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
