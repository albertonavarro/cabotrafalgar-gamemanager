package com.navid.gamemanager.rest.impl;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.navid.gamemanager.rest.*;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.provider.ProviderFactory;

import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alberto on 8/11/15.
 */
public class GameManagerClient {

    private String url;

    private List<Object> providers = new ArrayList<Object>();


    public GameManagerClient(String url) {
        this.url = url;
        providers.add( new JacksonJaxbJsonProvider() );

    }

    public RestGame createNewGame(RestScope scope, String mode, String map) {
        WebClient client = WebClient.create(url, providers);
        client.path("games");
        client.type("application/json").accept("application/json");

        Response r = client.put(new GameCreationRequest(scope, mode, map));
        GameCreationResponse game = r.readEntity(GameCreationResponse.class);
        return game.getGame();
    }

    public URL addPlayer(RestGame game, String role, String name, Collection<RestControl> controls) {
        WebClient client = WebClient.create(url, providers);
        client.path("games/" + game.getId());
        client.type("application/json").accept("application/json");

        Response r = client.put(new AddPlayerRequest(role, name, controls));
        AddPlayerResponse player = r.readEntity(AddPlayerResponse.class);
        try {
            return new URL(url + "/invitation/" + player.getInvitation());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}
