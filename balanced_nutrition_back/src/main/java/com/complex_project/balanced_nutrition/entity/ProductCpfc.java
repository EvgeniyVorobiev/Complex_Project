package com.complex_project.balanced_nutrition.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "product_cpfc", schema = "cp")
public class ProductCpfc {
    @Id
    @Column(name = "id_product_cpfc", nullable = false)
    private Integer id;

    @Column(name = "weight_cpfc", nullable = false)
    private Float weightCpfc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_product", nullable = false)
    private Product idProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_cpfc_directory", nullable = false)
    private CpfcDirectory idCpfcDirectory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getWeightCpfc() {
        return weightCpfc;
    }

    public void setWeightCpfc(Float weightCpfc) {
        this.weightCpfc = weightCpfc;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public CpfcDirectory getIdCpfcDirectory() {
        return idCpfcDirectory;
    }

    public void setIdCpfcDirectory(CpfcDirectory idCpfcDirectory) {
        this.idCpfcDirectory = idCpfcDirectory;
    }

}