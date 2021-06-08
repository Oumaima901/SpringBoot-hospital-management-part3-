package tn.itbs.spring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}