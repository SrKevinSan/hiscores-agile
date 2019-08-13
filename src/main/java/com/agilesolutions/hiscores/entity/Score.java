package com.agilesolutions.hiscores.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
@Table(name = "score")
//@JsonIgnoreProperties(value={ "category" }, allowGetters= false)
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer score;

    @JsonIgnoreProperties("score")
    @ManyToOne
    private Category category;

    @JsonIgnoreProperties("score")
    @ManyToOne
    private Player player;

    public Score(int id, Integer score, Player player, Category category) {
        this.id = id;
        this.score = score;
        this.player = player;
        this.category = category;
    }

    public Score() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getScoreInt() {
        return Integer.valueOf(this.score);
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
