package com.navid.gamemanager.restclient;

import com.navid.gamemanager.domain.Scope;

import javax.validation.constraints.NotNull;

/**
 * Created by alberto on 7/24/15.
 */
public class GameCreationRequest {

    @NotNull
    private Scope scope;

    @NotNull
    private String mode;

    @NotNull
    private String map;

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
