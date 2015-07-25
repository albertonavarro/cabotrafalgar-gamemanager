package com.navid.gamemanager.restclient;

import com.navid.gamemanager.domain.Game;

/**
 * Created by alberto on 7/19/15.
 */
public class GameCreationResponse extends GenericResponse {

    private final Game game;

    public GameCreationResponse(Game game) {
        this.game = game;
    }

    public GameCreationResponse(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
        this.game = null;
    }

    public Game getGame() {
        return game;
    }
}
