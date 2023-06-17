package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.ProductCollection}
 */
public class ProductCollectionDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String imageLink;
    private final UserCpDto idUser;

    public ProductCollectionDto(Integer id, String name, String imageLink, UserCpDto idUser) {
        this.id = id;
        this.name = name;
        this.imageLink = imageLink;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageLink() {
        return imageLink;
    }

    public UserCpDto getIdUser() {
        return idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCollectionDto entity = (ProductCollectionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.imageLink, entity.imageLink) &&
                Objects.equals(this.idUser, entity.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageLink, idUser);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "imageLink = " + imageLink + ", " +
                "idUser = " + idUser + ")";
    }
}