package tn.itbs.spring.service;

import tn.itbs.spring.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}