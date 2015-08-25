package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPlayerRequest {

    private final String role;

    private final String name;

    private final Collection<RestControl> controls;

    @JsonCreator
    public AddPlayerRequest(@JsonProperty("role") String role,
                            @JsonProperty("name") String name,
                            @JsonProperty("controls") Collection<RestControl> controls) {
        this.role = role;
        this.name = name;
        this.controls = controls;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public Collection<RestControl>  getControls() {
        return controls;
    }
}
