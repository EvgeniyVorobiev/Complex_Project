package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.Day}
 */
public class DayDto implements Serializable {
    private final Integer id;
    private final PlannedMenuDto idPlannedMenu;
    private final LocalDate dayDate;

    public DayDto(Integer id, PlannedMenuDto idPlannedMenu, LocalDate dayDate) {
        this.id = id;
        this.idPlannedMenu = idPlannedMenu;
        this.dayDate = dayDate;
    }

    public Integer getId() {
        return id;
    }

    public PlannedMenuDto getIdPlannedMenu() {
        return idPlannedMenu;
    }

    public LocalDate getDayDate() {
        return dayDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayDto entity = (DayDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idPlannedMenu, entity.idPlannedMenu) &&
                Objects.equals(this.dayDate, entity.dayDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPlannedMenu, dayDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idPlannedMenu = " + idPlannedMenu + ", " +
                "dayDate = " + dayDate + ")";
    }
}