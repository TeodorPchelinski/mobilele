package com.example.mobilele.model.entity;

import com.example.mobilele.model.enums.ModelCategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BasedEntity{

    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategoryEnum category;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
