package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.model.User;
import com.example.reservationsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final Map<Long, User> userRepository = new HashMap<>();
    private long nextId = 1L;

    @Override
    public User createUser(User user) {
        user.setId(nextId++);
        userRepository.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.values());
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userRepository.get(id));
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.containsKey(id)) {
            user.setId(id);
            userRepository.put(id, user);
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.remove(id);
    }
}
