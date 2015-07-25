package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestPlayer {

    private Long id;

    private String name;

    private String role;

    private Collection<RestControl> controls;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<RestControl> getControls() {
        return controls;
    }

    public void setControls(Collection<RestControl> controls) {
        this.controls = controls;
    }
}
