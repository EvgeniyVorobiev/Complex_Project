package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "meal_dish", schema = "cp")
public class MealDish {
    @EmbeddedId
    private MealDishId id;

    @MapsId("idMeal")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_meal", nullable = false)
    private Meal idMeal;

    @MapsId("idDish")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_dish", nullable = false)
    private Dish idDish;

    @Column(name = "product_weight_netto", nullable = false)
    private Float productWeightNetto;

    public MealDishId getId() {
        return id;
    }

    public void setId(MealDishId id) {
        this.id = id;
    }

    public Meal getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Meal idMeal) {
        this.idMeal = idMeal;
    }

    public Dish getIdDish() {
        return idDish;
    }

    public void setIdDish(Dish idDish) {
        this.idDish = idDish;
    }

    public Float getProductWeightNetto() {
        return productWeightNetto;
    }

    public void setProductWeightNetto(Float productWeightNetto) {
        this.productWeightNetto = productWeightNetto;
    }

}