package com.navid.gamemanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by alberto on 7/19/15.
 */
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private Scope scope;

    @NotNull
    private String mode;

    @NotNull
    private String map;

    @NotNull
    @ManyToOne
    private Server server;

    public Game() {

    }

    public Game(Server server, String map, String mode, Scope scope) {
        this.server = server;
        this.map = map;
        this.mode = mode;
        this.scope = scope;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
