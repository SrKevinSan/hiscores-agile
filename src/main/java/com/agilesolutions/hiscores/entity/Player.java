package com.agilesolutions.hiscores.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EnableAutoConfiguration
@Table(name = "player")
@JsonIgnoreProperties(value={ "score", "id"}, allowSetters= true)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Transient
    private Integer xp;

    private int level;
    private String name;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "player")
    private List<Score> score = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "score",
            joinColumns = { @JoinColumn(name = "player_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id")})
    private List<Category> category = new ArrayList<>();

    public Player(int id, int level, String name, List<Score> score) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.score = score;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
    @Transient
    public Integer getXp() {
        return xp;
    }

    @Transient
    public void setXp(Integer xp) {
        this.xp = xp;
    }
}
