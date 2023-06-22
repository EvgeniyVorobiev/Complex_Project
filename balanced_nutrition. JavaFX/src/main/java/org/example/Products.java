package org.example;

import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;

public class Products {
    public int id_planned_menu;
    public String name;
    public Double weight;
    public String measure;

    public Products(int id_planned_menu, String name, Double weight, String measure) {
        this.id_planned_menu = id_planned_menu;
        this.name = name;
        this.weight = weight;
        this.measure = measure;
    }
    public Products() {
    }

    public int getId() {
        return id_planned_menu;
    }

    public void setId(int id_planned_menu) {
        this.id_planned_menu = id_planned_menu;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setMeasure(String measure) {
        this.measure = measure;
    }
    public String getMeasure() {
        return measure;
    }
}


