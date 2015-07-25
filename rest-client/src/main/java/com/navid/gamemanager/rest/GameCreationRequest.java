package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameCreationRequest {

    private RestScope scope;

    private String mode;

    private String map;

    public RestScope getScope() {
        return scope;
    }

    public void setScope(RestScope scope) {
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
