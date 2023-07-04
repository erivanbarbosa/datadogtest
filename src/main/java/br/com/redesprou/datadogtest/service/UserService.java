package br.com.redesprou.datadogtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.redesprou.datadogtest.model.User;

@Service
public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public User createUser(User user) {
        user.setId(generateUniqueId());
        users.add(user);
        return user;
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = getUserById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {
        Optional<User> user = getUserById(id);
        if (user.isPresent()) {
            users.remove(user.get());
            return true;
        }
        return false;
    }

    private int generateUniqueId() {
        return users.size() + 1;
    }
}
