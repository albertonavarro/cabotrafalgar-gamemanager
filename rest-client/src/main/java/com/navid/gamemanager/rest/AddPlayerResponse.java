package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPlayerResponse extends GenericResponse {

    private final RestPlayer player;

    private final Long invitation;

    public AddPlayerResponse(RestPlayer player, Long invitation) {
        this.player = player;
        this.invitation = invitation;
    }

    public AddPlayerResponse(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
        this.player = null;
        this.invitation = null;
    }

    public RestPlayer getPlayer() {
        return player;
    }

    public Long getInvitation() {
        return invitation;
    }
}
