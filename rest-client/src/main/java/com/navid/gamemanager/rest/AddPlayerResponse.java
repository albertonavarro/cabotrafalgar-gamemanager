package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPlayerResponse extends GenericResponse {

    private RestPlayer player;

    private Long invitation;

    public RestPlayer getPlayer() {
        return player;
    }

    public Long getInvitation() {
        return invitation;
    }

    public void setInvitation(Long invitation) {
        this.invitation = invitation;
    }

    public void setPlayer(RestPlayer player) {
        this.player = player;
    }

    public static AddPlayerResponse fromPlayer(RestPlayer player, Long invitation) {
        AddPlayerResponse response = new AddPlayerResponse();
        response.setPlayer(player);
        response.setInvitation(invitation);
        return response;
    }
}
