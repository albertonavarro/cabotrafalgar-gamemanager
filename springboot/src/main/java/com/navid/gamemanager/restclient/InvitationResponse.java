package com.navid.gamemanager.restclient;

import com.navid.gamemanager.domain.Control;

import java.net.URL;
import java.util.Collection;

/**
 * Created by alberto on 7/25/15.
 */
public class InvitationResponse extends GenericResponse {

    private final URL url;

    private final Long gameId;

    private final Iterable<Control> controls;

    public InvitationResponse(URL url, Long gameId, Iterable<Control> controls) {
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

    public Iterable<Control> getControls() {
        return controls;
    }
}
