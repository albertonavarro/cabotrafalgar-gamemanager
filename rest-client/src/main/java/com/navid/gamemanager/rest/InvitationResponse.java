package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URL;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvitationResponse extends GenericResponse {

    private final URL url;

    private final Long gameId;

    private final Iterable<RestControl> controls;

    public InvitationResponse(URL url, Long gameId, Iterable<RestControl> controls) {
        this.url = url;
        this.gameId = gameId;
        this.controls = controls;
    }

    public InvitationResponse(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
        this.url = null;
        this.gameId = null;
        this.controls = null;
    }

    public URL getUrl() {
        return url;
    }

    public Long getGameId() {
        return gameId;
    }

    public Iterable<RestControl> getControls() {
        return controls;
    }
}
