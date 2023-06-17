package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.PlannedMenu}
 */
public class PlannedMenuDto implements Serializable {
    private final Integer id;
    private final String name;
    private final UserCpDto idUser;
    private final GroupPmDto idGroupPm;

    public PlannedMenuDto(Integer id, String name, UserCpDto idUser, GroupPmDto idGroupPm) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
        this.idGroupPm = idGroupPm;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserCpDto getIdUser() {
        return idUser;
    }

    public GroupPmDto getIdGroupPm() {
        return idGroupPm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlannedMenuDto entity = (PlannedMenuDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.idUser, entity.idUser) &&
                Objects.equals(this.idGroupPm, entity.idGroupPm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idUser, idGroupPm);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "idUser = " + idUser + ", " +
                "idGroupPm = " + idGroupPm + ")";
    }
}