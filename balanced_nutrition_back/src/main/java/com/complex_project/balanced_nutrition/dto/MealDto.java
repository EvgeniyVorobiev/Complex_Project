package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.Meal}
 */
public class MealDto implements Serializable {
    private final Integer id;
    private final DayDto idDay;
    private final MealCollectionDto idMealCollection;

    public MealDto(Integer id, DayDto idDay, MealCollectionDto idMealCollection) {
        this.id = id;
        this.idDay = idDay;
        this.idMealCollection = idMealCollection;
    }

    public Integer getId() {
        return id;
    }

    public DayDto getIdDay() {
        return idDay;
    }

    public MealCollectionDto getIdMealCollection() {
        return idMealCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealDto entity = (MealDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idDay, entity.idDay) &&
                Objects.equals(this.idMealCollection, entity.idMealCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idDay, idMealCollection);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idDay = " + idDay + ", " +
                "idMealCollection = " + idMealCollection + ")";
    }
}