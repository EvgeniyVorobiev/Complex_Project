package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_book", schema = "cp")
public class RecipeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe_book", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "image_link", nullable = false, length = 100)
    private String imageLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dish_collection", nullable = false)
    private DishCollection idDishCollection;

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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public DishCollection getIdDishCollection() {
        return idDishCollection;
    }

    public void setIdDishCollection(DishCollection idDishCollection) {
        this.idDishCollection = idDishCollection;
    }

}