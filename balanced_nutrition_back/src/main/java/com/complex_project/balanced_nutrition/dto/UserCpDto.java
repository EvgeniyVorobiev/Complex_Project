package com.complex_project.balanced_nutrition.dto;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.UserCp}
 */
public class UserCpDto implements Serializable {
    private final Integer id;
    private final String login;
    private final String password;
    private final String email;
    private final RoleDto idRole;


    public UserCpDto(Integer id, String login, String password, String email, RoleDto idRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.idRole = idRole;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public RoleDto getIdRole() {
        return idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCpDto entity = (UserCpDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.login, entity.login) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.idRole, entity.idRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, idRole);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "login = " + login + ", " +
                "password = " + password + ", " +
                "email = " + email + ", " +
                "idRole = " + idRole + ")";
    }
}