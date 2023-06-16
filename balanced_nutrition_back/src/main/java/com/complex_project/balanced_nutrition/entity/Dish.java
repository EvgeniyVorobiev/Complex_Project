package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dish", schema = "cp")
public class Dish {
    @Id
    @Column(name = "id_dish", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "dish_weight", nullable = false)
    private Float dishWeight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dish_processing", nullable = false)
    private DishProcessing idDishProcessing;

    @Column(name = "cooking_technology", nullable = false, length = Integer.MAX_VALUE)
    private String cookingTechnology;

    @Column(name = "dish_characteristic", nullable = false, length = Integer.MAX_VALUE)
    private String dishCharacteristic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recipe_book", nullable = false)
    private RecipeBook idRecipeBook;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDishWeight() {
        return dishWeight;
    }

    public void setDishWeight(Float dishWeight) {
        this.dishWeight = dishWeight;
    }

    public DishProcessing getIdDishProcessing() {
        return idDishProcessing;
    }

    public void setIdDishProcessing(DishProcessing idDishProcessing) {
        this.idDishProcessing = idDishProcessing;
    }

    public String getCookingTechnology() {
        return cookingTechnology;
    }

    public void setCookingTechnology(String cookingTechnology) {
        this.cookingTechnology = cookingTechnology;
    }

    public String getDishCharacteristic() {
        return dishCharacteristic;
    }

    public void setDishCharacteristic(String dishCharacteristic) {
        this.dishCharacteristic = dishCharacteristic;
    }

    public RecipeBook getIdRecipeBook() {
        return idRecipeBook;
    }

    public void setIdRecipeBook(RecipeBook idRecipeBook) {
        this.idRecipeBook = idRecipeBook;
    }

}