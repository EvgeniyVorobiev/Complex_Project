package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.Product}
 */
public class ProductDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Float productWeightBrutto;
    private final ProductMeasureDto idProductMeasure;
    private final String productShelfLife;
    private final ProductCollectionDto idProductCollection;

    public ProductDto(Integer id, String name, Float productWeightBrutto, ProductMeasureDto idProductMeasure, String productShelfLife, ProductCollectionDto idProductCollection) {
        this.id = id;
        this.name = name;
        this.productWeightBrutto = productWeightBrutto;
        this.idProductMeasure = idProductMeasure;
        this.productShelfLife = productShelfLife;
        this.idProductCollection = idProductCollection;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getProductWeightBrutto() {
        return productWeightBrutto;
    }

    public ProductMeasureDto getIdProductMeasure() {
        return idProductMeasure;
    }

    public String getProductShelfLife() {
        return productShelfLife;
    }

    public ProductCollectionDto getIdProductCollection() {
        return idProductCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.productWeightBrutto, entity.productWeightBrutto) &&
                Objects.equals(this.idProductMeasure, entity.idProductMeasure) &&
                Objects.equals(this.productShelfLife, entity.productShelfLife) &&
                Objects.equals(this.idProductCollection, entity.idProductCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productWeightBrutto, idProductMeasure, productShelfLife, idProductCollection);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "productWeightBrutto = " + productWeightBrutto + ", " +
                "idProductMeasure = " + idProductMeasure + ", " +
                "productShelfLife = " + productShelfLife + ", " +
                "idProductCollection = " + idProductCollection + ")";
    }
}