package com.navid.gamemanager.domain;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by alberto on 7/24/15.
 */
@Entity
public class Control {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
