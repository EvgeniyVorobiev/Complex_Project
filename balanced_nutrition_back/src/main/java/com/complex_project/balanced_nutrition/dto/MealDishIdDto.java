package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.MealDishId}
 */
public class MealDishIdDto implements Serializable {
    private final Integer idMeal;
    private final Integer idDish;

    public MealDishIdDto(Integer idMeal, Integer idDish) {
        this.idMeal = idMeal;
        this.idDish = idDish;
    }

    public Integer getIdMeal() {
        return idMeal;
    }

    public Integer getIdDish() {
        return idDish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealDishIdDto entity = (MealDishIdDto) o;
        return Objects.equals(this.idMeal, entity.idMeal) &&
                Objects.equals(this.idDish, entity.idDish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMeal, idDish);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idMeal = " + idMeal + ", " +
                "idDish = " + idDish + ")";
    }
}