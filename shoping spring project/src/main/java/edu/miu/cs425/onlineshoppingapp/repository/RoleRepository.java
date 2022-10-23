package edu.miu.cs425.onlineshoppingapp.repository;

import edu.miu.cs425.onlineshoppingapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
