package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role", schema = "cp")
public class Role {
    @Id
    @Column(name = "id_role", nullable = false)
    private Short id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}