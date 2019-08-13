package com.agilesolutions.hiscores.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EnableAutoConfiguration
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonIgnoreProperties(value={"category"})
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "category")
    private List<Score> score = new ArrayList<>();

    public Category(int id, String name, List<Score> score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    protected Category() {
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

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }
}
