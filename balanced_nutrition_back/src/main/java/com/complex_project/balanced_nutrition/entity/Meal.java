package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "meal", schema = "cp")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meal", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_day", nullable = false)
    private Day idDay;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_meal_collection", nullable = false)
    private MealCollection idMealCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Day getIdDay() {
        return idDay;
    }

    public void setIdDay(Day idDay) {
        this.idDay = idDay;
    }

    public MealCollection getIdMealCollection() {
        return idMealCollection;
    }

    public void setIdMealCollection(MealCollection idMealCollection) {
        this.idMealCollection = idMealCollection;
    }

}