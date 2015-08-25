package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URL;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvitationResponse extends GenericResponse {

    private String url;

    private Long gameId;

    private Iterable<RestControl> controls;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setControls(Iterable<RestControl> controls) {
        this.controls = controls;
    }

    public String getUrl() {
        return url;
    }

    public Long getGameId() {
        return gameId;
    }

    public Iterable<RestControl> getControls() {
        return controls;
    }

    public static InvitationResponse fromUrl(String url, Long gameId, Iterable<RestControl> controls) {
        InvitationResponse invitationResponse = new InvitationResponse();
        invitationResponse.setControls(controls);
        invitationResponse.setGameId(gameId);
        invitationResponse.setUrl(url);
        return invitationResponse;
    }
}
