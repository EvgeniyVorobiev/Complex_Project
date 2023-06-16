package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dish_collection", schema = "cp")
public class DishCollection {
    @Id
    @Column(name = "id_dish_collection", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserCp idUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCp getIdUser() {
        return idUser;
    }

    public void setIdUser(UserCp idUser) {
        this.idUser = idUser;
    }

}