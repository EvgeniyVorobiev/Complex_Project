package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.RoleRepository;
import com.complex_project.balanced_nutrition.repository.UserCpRepository;
import com.complex_project.balanced_nutrition.service.UserService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    private final UserCpRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserCpRepository userRepository,
                           RoleRepository roleRepository) {
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserCp createUser(UserCp user, short id_role) {
        user.setPassword(hashPassword(user.getPassword()));
        user.setIdRole(roleRepository.getById(id_role));
        return userRepository.save(user);
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public UserCp getUserByLoginAndPassword(String login, String password) {

        return userRepository.getUserCpByLoginOrEmailAndPassword(login, password);
    }

    @Override
    public UserCp getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserCp getUserByLogin(String login) {
        return userRepository.getUserCpByLogin(login);
    }

}
