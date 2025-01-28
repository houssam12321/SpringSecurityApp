package com.example.loginDemo.repository;

import com.example.loginDemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name); // Method to find a role by its name

}
