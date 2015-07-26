package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameCreationRequest {

    private final RestScope scope;

    private final String mode;

    private final String map;

    @JsonCreator
    public GameCreationRequest(
            @JsonProperty("scope") RestScope scope,
            @JsonProperty("mode")  String mode,
            @JsonProperty("map")   String map) {
        this.scope = scope;
        this.mode = mode;
        this.map = map;
    }

    public RestScope getScope() {
        return scope;
    }


    public String getMode() {
        return mode;
    }


    public String getMap() {
        return map;
    }

}
