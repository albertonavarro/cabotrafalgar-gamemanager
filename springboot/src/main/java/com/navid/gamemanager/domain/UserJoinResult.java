package com.navid.gamemanager.domain;

/**
 * Created by alberto on 7/19/15.
 */
public class UserJoinResult {

    private User user;

    private Game game;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
