package com.navid.gamemanager.domain;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alberto on 7/24/15.
 */
@Entity
public class Control {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private String controlGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getControlGroup() {
        return controlGroup;
    }

    public void setControlGroup(String controlGroup) {
        this.controlGroup = controlGroup;
    }
}
