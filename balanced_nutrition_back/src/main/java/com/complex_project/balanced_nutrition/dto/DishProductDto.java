package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.DishProduct}
 */
public class DishProductDto implements Serializable {
    private final DishProductIdDto id;
    private final DishDto idDish;
    private final ProductDto idProduct;
    private final Float productWeightNetto;

    public DishProductDto(DishProductIdDto id, DishDto idDish, ProductDto idProduct, Float productWeightNetto) {
        this.id = id;
        this.idDish = idDish;
        this.idProduct = idProduct;
        this.productWeightNetto = productWeightNetto;
    }

    public DishProductIdDto getId() {
        return id;
    }

    public DishDto getIdDish() {
        return idDish;
    }

    public ProductDto getIdProduct() {
        return idProduct;
    }

    public Float getProductWeightNetto() {
        return productWeightNetto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishProductDto entity = (DishProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idDish, entity.idDish) &&
                Objects.equals(this.idProduct, entity.idProduct) &&
                Objects.equals(this.productWeightNetto, entity.productWeightNetto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idDish, idProduct, productWeightNetto);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idDish = " + idDish + ", " +
                "idProduct = " + idProduct + ", " +
                "productWeightNetto = " + productWeightNetto + ")";
    }
}