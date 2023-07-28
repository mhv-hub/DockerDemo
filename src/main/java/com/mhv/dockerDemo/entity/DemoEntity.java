package com.mhv.dockerDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entity_table")
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public DemoEntity() {
    }

    public DemoEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
