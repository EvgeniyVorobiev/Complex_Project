package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "day", schema = "cp")
public class Day {
    @Id
    @Column(name = "id_day", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_planned_menu", nullable = false)
    private PlannedMenu idPlannedMenu;

    @Column(name = "day_date", nullable = false)
    private LocalDate dayDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlannedMenu getIdPlannedMenu() {
        return idPlannedMenu;
    }

    public void setIdPlannedMenu(PlannedMenu idPlannedMenu) {
        this.idPlannedMenu = idPlannedMenu;
    }

    public LocalDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(LocalDate dayDate) {
        this.dayDate = dayDate;
    }

}