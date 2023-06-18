package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product", schema = "cp")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "product_weight_brutto", nullable = false)
    private Float productWeightBrutto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product_measure", nullable = false)
    private ProductMeasure idProductMeasure;

    @Column(name = "product_shelf_life", nullable = false, length = 40)
    private String productShelfLife;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product_collection", nullable = false)
    private ProductCollection idProductCollection;

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

    public Float getProductWeightBrutto() {
        return productWeightBrutto;
    }

    public void setProductWeightBrutto(Float productWeightBrutto) {
        this.productWeightBrutto = productWeightBrutto;
    }

    public ProductMeasure getIdProductMeasure() {
        return idProductMeasure;
    }

    public void setIdProductMeasure(ProductMeasure idProductMeasure) {
        this.idProductMeasure = idProductMeasure;
    }

    public String getProductShelfLife() {
        return productShelfLife;
    }

    public void setProductShelfLife(String productShelfLife) {
        this.productShelfLife = productShelfLife;
    }

    public ProductCollection getIdProductCollection() {
        return idProductCollection;
    }

    public void setIdProductCollection(ProductCollection idProductCollection) {
        this.idProductCollection = idProductCollection;
    }

}