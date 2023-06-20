package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.entity.UserCp;

public interface UserService {
    UserCp createUser(UserCp user, short id_role);
    UserCp getUserByLoginAndPassword(String login, String password);

    UserCp getUserById(int id);

    UserCp getUserByLogin(String login);
}
