package com.navid.gamemanager.domain;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by alberto on 7/24/15.
 */
@Entity
public class Control {

    @Id
    private String name;

    private String type;

    private String controlGroup;

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
