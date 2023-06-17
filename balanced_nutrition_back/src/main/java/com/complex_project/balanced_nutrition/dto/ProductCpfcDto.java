package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.ProductCpfc}
 */
public class ProductCpfcDto implements Serializable {
    private final Integer id;
    private final Float weightCpfc;
    private final ProductDto idProduct;
    private final CpfcDirectoryDto idCpfcDirectory;

    public ProductCpfcDto(Integer id, Float weightCpfc, ProductDto idProduct, CpfcDirectoryDto idCpfcDirectory) {
        this.id = id;
        this.weightCpfc = weightCpfc;
        this.idProduct = idProduct;
        this.idCpfcDirectory = idCpfcDirectory;
    }

    public Integer getId() {
        return id;
    }

    public Float getWeightCpfc() {
        return weightCpfc;
    }

    public ProductDto getIdProduct() {
        return idProduct;
    }

    public CpfcDirectoryDto getIdCpfcDirectory() {
        return idCpfcDirectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCpfcDto entity = (ProductCpfcDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.weightCpfc, entity.weightCpfc) &&
                Objects.equals(this.idProduct, entity.idProduct) &&
                Objects.equals(this.idCpfcDirectory, entity.idCpfcDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weightCpfc, idProduct, idCpfcDirectory);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "weightCpfc = " + weightCpfc + ", " +
                "idProduct = " + idProduct + ", " +
                "idCpfcDirectory = " + idCpfcDirectory + ")";
    }
}