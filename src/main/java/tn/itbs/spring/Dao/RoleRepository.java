package tn.itbs.spring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.itbs.spring.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
