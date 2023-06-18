package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "planned_menu", schema = "cp")
public class PlannedMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planned_menu", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private UserCp idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_group_pm", nullable = false)
    private GroupPm idGroupPm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCp getIdUser() {
        return idUser;
    }

    public void setIdUser(UserCp idUser) {
        this.idUser = idUser;
    }

    public GroupPm getIdGroupPm() {
        return idGroupPm;
    }

    public void setIdGroupPm(GroupPm idGroupPm) {
        this.idGroupPm = idGroupPm;
    }

}