package com.navid.gamemanager.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alberto on 7/19/15.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String role;

    @NotNull
    @ManyToOne
    private Game game;

    @NotNull
    @OneToMany
    private Collection<Control> controls;

    public Player() {

    }

    public Player(Game game, String name, String role, Collection<Control> controls) {
        this.game = game;
        this.name = name;
        this.role = role;
        this.controls = controls;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Iterable<Control> getControls() {
        return controls;
    }

    public void setControls(Collection<Control> controls) {
        this.controls = controls;
    }

    public String getRole() {
        return role;
    }
}
