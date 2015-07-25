package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPlayerRequest {

    private String role;

    private String name;

    private List<RestControl> controls;

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

    public List<RestControl>  getControls() {
        return controls;
    }

    public void setControls(List<RestControl> controls) {
        this.controls = controls;
    }
}
