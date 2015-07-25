package com.navid.gamemanager.restclient;

import com.navid.gamemanager.domain.Game;
import com.navid.gamemanager.domain.Invitation;
import com.navid.gamemanager.domain.Player;

/**
 * Created by alberto on 7/19/15.
 */
public class AddPlayerResponse extends GenericResponse {

    private final Player player;

    private final Long invitation;

    public AddPlayerResponse(Player player, Long invitation) {
        this.player = player;
        this.invitation = invitation;
    }

    public AddPlayerResponse(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
        this.player = null;
        this.invitation = null;
    }

    public Player getPlayer() {
        return player;
    }

    public Long getInvitation() {
        return invitation;
    }
}
