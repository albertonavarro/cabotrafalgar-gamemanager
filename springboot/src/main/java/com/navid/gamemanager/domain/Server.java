package com.navid.gamemanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URL;

/**
 * Created by alberto on 7/24/15.
 */
@Entity
public class Server {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private URL url;

    public Server() {

    }

    public Server(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
