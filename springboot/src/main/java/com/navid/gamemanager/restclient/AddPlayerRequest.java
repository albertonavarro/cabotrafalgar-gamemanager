package com.navid.gamemanager.restclient;

import com.navid.gamemanager.domain.Control;

import java.util.List;

/**
 * Created by alberto on 7/25/15.
 */
public class AddPlayerRequest {

    private String role;

    private String name;

    private List<Control> controls;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Control>  getControls() {
        return controls;
    }

    public void setControls(List<Control> controls) {
        this.controls = controls;
    }
}
