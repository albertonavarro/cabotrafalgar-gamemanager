package com.navid.gamemanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by alberto on 7/19/15.
 */
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Scope scope;

    private java.lang.String mode;

    private java.lang.String map;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getMap() {
        return map;
    }

    public void setMap(java.lang.String map) {
        this.map = map;
    }

    public java.lang.String getMode() {
        return mode;
    }

    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
