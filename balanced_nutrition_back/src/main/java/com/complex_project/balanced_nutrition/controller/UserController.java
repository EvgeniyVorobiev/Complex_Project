package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.RoleDto;
import com.complex_project.balanced_nutrition.dto.UserCpDto;
import com.complex_project.balanced_nutrition.entity.Role;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.RoleRepository;
import com.complex_project.balanced_nutrition.repository.UserCpRepository;
import com.complex_project.balanced_nutrition.service.UserService;
import com.complex_project.balanced_nutrition.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<UserCpDto> getByLogin(@PathVariable String login){
        user = userService.getUserByLogin(login);
        if (user != null){

            UserCpDto userCpDto = new UserCpDto(user.getId(), user.getLogin(), user.getPassword(), user.getEmail(),
                    new RoleDto((user.getIdRole().getId()), user.getIdRole().getName())
            );

            return new ResponseEntity<>(userCpDto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/getByLoginAndPassword/{login}/{password}")
    public ResponseEntity<UserCpDto> getByLoginAndPassword(@PathVariable String login, @PathVariable String password){
        String hashedPassword = UserServiceImpl.hashPassword(password);
        user = userService.getUserByLoginAndPassword(login, hashedPassword);
        if (user != null){

            UserCpDto userCpDto = new UserCpDto(user.getId(), user.getLogin(), user.getPassword(), user.getEmail(),
                    new RoleDto((user.getIdRole().getId()), user.getIdRole().getName())
            );

            return new ResponseEntity<>(userCpDto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCpDto> getById(@PathVariable int id){
        user = userService.getUserById(id);
        if (user != null){

            UserCpDto userCpDto = new UserCpDto(user.getId(), user.getLogin(), user.getPassword(), user.getEmail(),
                    new RoleDto((user.getIdRole().getId()), user.getIdRole().getName())
                    );
            return new ResponseEntity<>(userCpDto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
