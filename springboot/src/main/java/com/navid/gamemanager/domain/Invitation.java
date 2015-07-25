package com.navid.gamemanager.domain;

import javax.persistence.*;

/**
 * Created by alberto on 7/25/15.
 */
@Entity
public class Invitation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Player player;

    public Invitation() {

    }

    public Invitation(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
