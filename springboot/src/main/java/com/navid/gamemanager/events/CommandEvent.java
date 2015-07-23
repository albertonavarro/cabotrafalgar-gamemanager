package com.navid.gamemanager.events;

/**
 * Created by alberto on 7/23/15.
 */

public class CommandEvent extends AbstractEvent {

    private String commandId;

    private Float value;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }
}
