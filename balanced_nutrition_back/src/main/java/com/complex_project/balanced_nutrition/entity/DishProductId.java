package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DishProductId implements Serializable {
    private static final long serialVersionUID = 848144135172882041L;
    @Column(name = "id_dish", nullable = false)
    private Integer idDish;

    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    public Integer getIdDish() {
        return idDish;
    }

    public void setIdDish(Integer idDish) {
        this.idDish = idDish;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DishProductId entity = (DishProductId) o;
        return Objects.equals(this.idProduct, entity.idProduct) &&
                Objects.equals(this.idDish, entity.idDish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idDish);
    }

}