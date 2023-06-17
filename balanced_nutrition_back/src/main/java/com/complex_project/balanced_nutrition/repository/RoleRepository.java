package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Short> {
//    @Query ("select r from Role r where r.id = ?1")
//    Role getRoleById(short id);
}