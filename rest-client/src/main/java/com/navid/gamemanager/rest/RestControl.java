package com.navid.gamemanager.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestControl {

    private String name;

    private String type;

    private String group;

    public RestControl() {

    }

    @JsonCreator
    public RestControl(@JsonProperty("name") String name,
                       @JsonProperty("type") String type,
                       @JsonProperty("group") String group) {
        this.name = name;
        this.type = type;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
