package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameCreationResponse extends GenericResponse {

    private final RestGame game;

    public GameCreationResponse(RestGame game) {
        this.game = game;
    }

    public GameCreationResponse(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
        this.game = null;
    }

    public RestGame getGame() {
        return game;
    }
}
