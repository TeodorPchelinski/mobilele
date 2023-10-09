package com.example.mobilele.model.entity;
import jakarta.persistence.*;


// This is the way of parenting all other entity classes
@MappedSuperclass
public class BasedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public BasedEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
