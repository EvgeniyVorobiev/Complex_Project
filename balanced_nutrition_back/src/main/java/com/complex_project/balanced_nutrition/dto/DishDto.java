package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.Dish}
 */
public class DishDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Float dishWeight;
    private final DishProcessingDto idDishProcessing;
    private final String cookingTechnology;
    private final String dishCharacteristic;
    private final RecipeBookDto idRecipeBook;

    public DishDto(Integer id, String name, Float dishWeight, DishProcessingDto idDishProcessing, String cookingTechnology, String dishCharacteristic, RecipeBookDto idRecipeBook) {
        this.id = id;
        this.name = name;
        this.dishWeight = dishWeight;
        this.idDishProcessing = idDishProcessing;
        this.cookingTechnology = cookingTechnology;
        this.dishCharacteristic = dishCharacteristic;
        this.idRecipeBook = idRecipeBook;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getDishWeight() {
        return dishWeight;
    }

    public DishProcessingDto getIdDishProcessing() {
        return idDishProcessing;
    }

    public String getCookingTechnology() {
        return cookingTechnology;
    }

    public String getDishCharacteristic() {
        return dishCharacteristic;
    }

    public RecipeBookDto getIdRecipeBook() {
        return idRecipeBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishDto entity = (DishDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.dishWeight, entity.dishWeight) &&
                Objects.equals(this.idDishProcessing, entity.idDishProcessing) &&
                Objects.equals(this.cookingTechnology, entity.cookingTechnology) &&
                Objects.equals(this.dishCharacteristic, entity.dishCharacteristic) &&
                Objects.equals(this.idRecipeBook, entity.idRecipeBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dishWeight, idDishProcessing, cookingTechnology, dishCharacteristic, idRecipeBook);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "dishWeight = " + dishWeight + ", " +
                "idDishProcessing = " + idDishProcessing + ", " +
                "cookingTechnology = " + cookingTechnology + ", " +
                "dishCharacteristic = " + dishCharacteristic + ", " +
                "idRecipeBook = " + idRecipeBook + ")";
    }
}