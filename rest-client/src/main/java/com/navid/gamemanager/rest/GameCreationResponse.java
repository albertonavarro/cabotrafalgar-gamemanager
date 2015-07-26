package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameCreationResponse extends GenericResponse {

    private RestGame game;

    public GameCreationResponse() {
    }

    public RestGame getGame() {
        return game;
    }

    public void setGame(RestGame game) {
        this.game = game;
    }

    public static GameCreationResponse fromGame(RestGame game) {
        GameCreationResponse response = new GameCreationResponse();
        response.setGame(game);
        return response;
    }

}
