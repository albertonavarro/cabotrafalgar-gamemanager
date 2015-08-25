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
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface DomainMapper {

    DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

    RestPlayer convertPlayer(Player player);

    @IterableMapping(elementTargetType = RestPlayer.class)
    Collection<RestPlayer> convertPlayers(Iterable<Player> players);

    @IterableMapping(elementTargetType = RestControl.class)
    Collection<RestControl> convertControls(Iterable<Control> controls);

    @Mapping(source = "controlGroup", target = "group")
    RestControl convertControl(Control control);

    Scope convertScope(RestScope scope);

    RestGame convertGame(Game game);

    @IterableMapping(elementTargetType = Control.class)
    Iterable<Control> convertControls(Collection<RestControl> controls);

    @Mapping(source = "group", target = "controlGroup")
    Control convertControl(RestControl control);

    RestScope convertScope(Scope value);
}
