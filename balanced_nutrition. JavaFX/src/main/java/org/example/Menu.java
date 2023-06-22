package org.example;

import java.time.LocalDate;

public class Menu {
    public int planned_menu_id;
    public String planned_menu_name;
    public String group_pm_name;
    public LocalDate day_date;
    public String meal_name;
    public String dish_name;

    public Menu(){

    }
    public Menu(int planned_menu_id, String planned_menu_name, String group_pm_name, LocalDate day_date, String meal_name, String dish_name){
        this.planned_menu_id = planned_menu_id;
        this.planned_menu_name = planned_menu_name;
        this.group_pm_name = group_pm_name;
        this.day_date = day_date;
        this.meal_name = meal_name;
        this.dish_name = dish_name;
    }

    public int getPlanned_menu_id() {
        return planned_menu_id;
    }

    public void setPlanned_menu_id(int planned_menu_id) {
        this.planned_menu_id = planned_menu_id;
    }

    public String getGroup_pm_name() {
        return group_pm_name;
    }

    public void setGroup_pm_name(String group_pm_name) {
        this.group_pm_name = group_pm_name;
    }

    public LocalDate getDay_date() {
        return day_date;
    }

    public void setDay_date(LocalDate day_date) {
        this.day_date = day_date;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
}
