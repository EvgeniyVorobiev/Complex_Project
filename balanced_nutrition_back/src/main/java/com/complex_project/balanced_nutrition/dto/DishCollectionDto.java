package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.DishCollection}
 */
public class DishCollectionDto implements Serializable {
    private final Integer id;
    private final String name;
    private final UserCpDto idUser;

    public DishCollectionDto(Integer id, String name, UserCpDto idUser) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserCpDto getIdUser() {
        return idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishCollectionDto entity = (DishCollectionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.idUser, entity.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idUser);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "idUser = " + idUser + ")";
    }
}