package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.entity.Role;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.RoleRepository;
import com.complex_project.balanced_nutrition.repository.UserCpRepository;
import com.complex_project.balanced_nutrition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private UserCp user;
    private final RoleRepository roleRepository;
    private final UserCpRepository userCpRepository;

    @PostMapping("/register")
    public ResponseEntity<UserCp> registerUser(@RequestBody(  ) UserCp user){
        UserCp createdUser = userService.createUser(user, (short) 2);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getByLogin/{login}")
    public ResponseEntity<UserCp> getByLogin(@PathVariable String login){
        UserCp user = userService.getUserByLogin(login);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserCp> getById(@PathVariable Integer id){
        UserCp user = userService.getUserById(id);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
