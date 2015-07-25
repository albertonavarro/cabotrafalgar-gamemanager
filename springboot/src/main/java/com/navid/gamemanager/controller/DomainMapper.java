package com.navid.gamemanager.controller;

import com.navid.gamemanager.domain.Control;
import com.navid.gamemanager.domain.Game;
import com.navid.gamemanager.domain.Player;
import com.navid.gamemanager.domain.Scope;
import com.navid.gamemanager.rest.RestControl;
import com.navid.gamemanager.rest.RestGame;
import com.navid.gamemanager.rest.RestPlayer;
import com.navid.gamemanager.rest.RestScope;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface DomainMapper {

    DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

    RestPlayer convertPlayer(Player player);

    @IterableMapping(elementTargetType = RestControl.class)
    Collection<RestControl> convertControls(Iterable<Control> controls);

    RestControl convertControl(Control control);

    Scope convertScope(RestScope scope);

    RestGame convertGame(Game game);

    @IterableMapping(elementTargetType = Control.class)
    Iterable<Control> convertControls(List<RestControl> controls);

    Control convertControl(RestControl control);

    RestScope convertScope(Scope value);
}
