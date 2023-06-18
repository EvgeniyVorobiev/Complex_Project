package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.UserCp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserCpRepository extends JpaRepository<UserCp, Integer> {
    @Query("select u from UserCp u where (u.login = ?1 or u.email = ?1) and u.password = ?2")
    UserCp getUserCpByLoginOrEmailAndPassword(String login, String password);
    @Query("select u from UserCp u where (u.login = ?1 or u.email = ?1)")
    UserCp getUserCpByLogin(String login);
    @Query("select u from UserCp u where u.id = ?1")
    UserCp getUserCpById(Integer id);
}