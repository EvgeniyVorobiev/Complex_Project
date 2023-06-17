package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.DishProductId}
 */
public class DishProductIdDto implements Serializable {
    private final Integer idDish;
    private final Integer idProduct;

    public DishProductIdDto(Integer idDish, Integer idProduct) {
        this.idDish = idDish;
        this.idProduct = idProduct;
    }

    public Integer getIdDish() {
        return idDish;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishProductIdDto entity = (DishProductIdDto) o;
        return Objects.equals(this.idDish, entity.idDish) &&
                Objects.equals(this.idProduct, entity.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDish, idProduct);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idDish = " + idDish + ", " +
                "idProduct = " + idProduct + ")";
    }
}