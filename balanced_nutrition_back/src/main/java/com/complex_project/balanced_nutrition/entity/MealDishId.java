package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealDishId implements Serializable {
    private static final long serialVersionUID = 1154520161540557455L;
    @Column(name = "id_meal", nullable = false)
    private Integer idMeal;

    @Column(name = "id_dish", nullable = false)
    private Integer idDish;

    public Integer getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Integer idMeal) {
        this.idMeal = idMeal;
    }

    public Integer getIdDish() {
        return idDish;
    }

    public void setIdDish(Integer idDish) {
        this.idDish = idDish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MealDishId entity = (MealDishId) o;
        return Objects.equals(this.idDish, entity.idDish) &&
                Objects.equals(this.idMeal, entity.idMeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDish, idMeal);
    }

}