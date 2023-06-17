package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.MealDish}
 */
public class MealDishDto implements Serializable {
    private final MealDishIdDto id;
    private final MealDto idMeal;
    private final DishDto idDish;

    public MealDishDto(MealDishIdDto id, MealDto idMeal, DishDto idDish) {
        this.id = id;
        this.idMeal = idMeal;
        this.idDish = idDish;
    }

    public MealDishIdDto getId() {
        return id;
    }

    public MealDto getIdMeal() {
        return idMeal;
    }

    public DishDto getIdDish() {
        return idDish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealDishDto entity = (MealDishDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idMeal, entity.idMeal) &&
                Objects.equals(this.idDish, entity.idDish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMeal, idDish);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idMeal = " + idMeal + ", " +
                "idDish = " + idDish + ")";
    }
}