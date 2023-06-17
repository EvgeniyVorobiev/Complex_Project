package com.complex_project.balanced_nutrition.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.complex_project.balanced_nutrition.entity.GroupPm}
 */
public class GroupPmDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer numberOfServings;

    public GroupPmDto(Integer id, String name, Integer numberOfServings) {
        this.id = id;
        this.name = name;
        this.numberOfServings = numberOfServings;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupPmDto entity = (GroupPmDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.numberOfServings, entity.numberOfServings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfServings);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "numberOfServings = " + numberOfServings + ")";
    }
}