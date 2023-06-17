package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.RecipeBook}
 */
public class RecipeBookDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String imageLink;
    private final DishCollectionDto idDishCollection;

    public RecipeBookDto(Integer id, String name, String imageLink, DishCollectionDto idDishCollection) {
        this.id = id;
        this.name = name;
        this.imageLink = imageLink;
        this.idDishCollection = idDishCollection;
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

    public DishCollectionDto getIdDishCollection() {
        return idDishCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeBookDto entity = (RecipeBookDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.imageLink, entity.imageLink) &&
                Objects.equals(this.idDishCollection, entity.idDishCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageLink, idDishCollection);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "imageLink = " + imageLink + ", " +
                "idDishCollection = " + idDishCollection + ")";
    }
}