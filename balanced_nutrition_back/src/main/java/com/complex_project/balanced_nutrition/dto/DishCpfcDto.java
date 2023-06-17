package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.DishCpfc}
 */
public class DishCpfcDto implements Serializable {
    private final Integer id;
    private final Float weightCpfc;
    private final DishDto idDish;
    private final CpfcDirectoryDto idCpfcDirectory;

    public DishCpfcDto(Integer id, Float weightCpfc, DishDto idDish, CpfcDirectoryDto idCpfcDirectory) {
        this.id = id;
        this.weightCpfc = weightCpfc;
        this.idDish = idDish;
        this.idCpfcDirectory = idCpfcDirectory;
    }

    public Integer getId() {
        return id;
    }

    public Float getWeightCpfc() {
        return weightCpfc;
    }

    public DishDto getIdDish() {
        return idDish;
    }

    public CpfcDirectoryDto getIdCpfcDirectory() {
        return idCpfcDirectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishCpfcDto entity = (DishCpfcDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.weightCpfc, entity.weightCpfc) &&
                Objects.equals(this.idDish, entity.idDish) &&
                Objects.equals(this.idCpfcDirectory, entity.idCpfcDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weightCpfc, idDish, idCpfcDirectory);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "weightCpfc = " + weightCpfc + ", " +
                "idDish = " + idDish + ", " +
                "idCpfcDirectory = " + idCpfcDirectory + ")";
    }
}