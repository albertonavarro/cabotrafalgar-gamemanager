package com.navid.gamemanager.controller;

import com.google.common.collect.Lists;
import com.navid.gamemanager.domain.*;
import com.navid.gamemanager.persistence.*;
import com.navid.gamemanager.restclient.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by alberto on 7/19/15.
 */
@Controller
public class GameManagerController {

    @Resource
    private GameRepo gameRepo;

    @Resource
    private UserRepo playerRepo;

    @Resource
    private ServerRepo serverRepo;

    @Resource
    private ControlRepo controlRepo;

    @Resource
    private InvitationRepo invitationRepo;


    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public @ResponseBody Iterable<Game> listGames() {
        return gameRepo.findAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @RequestMapping(value = "/games", method = RequestMethod.PUT)
    public @ResponseBody
    GameCreationResponse createGame(@RequestBody GameCreationRequest gameInfo) {
        Server server = serverRepo.save(new Server());
        Game game = gameRepo.save(new Game(server, gameInfo.getMap(), gameInfo.getMode(), gameInfo.getScope()));
        return new GameCreationResponse(game);
    }

    @RequestMapping(value = "/games/{gameid}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Player> listPlayer(@PathVariable("gameid") Long gameId) {
        return playerRepo.findAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @RequestMapping(value = "/games/{gameid}", method = RequestMethod.PUT)
    public @ResponseBody
    AddPlayerResponse addPlayer(@RequestBody AddPlayerRequest playerInfo, @PathVariable("gameid") Long gameId) {
        Game game = gameRepo.findOne(gameId);
        Collection<Control> controls = newArrayList(controlRepo.save(playerInfo.getControls()));
        Player player = playerRepo.save(new Player(game, playerInfo.getName(), playerInfo.getRole(), controls));
        Invitation invitation = invitationRepo.save(new Invitation(player));
        return new AddPlayerResponse(player, invitation.getId());
    }

    @RequestMapping(value = "/invitation/{invitationid}", method = RequestMethod.GET)
    public @ResponseBody InvitationResponse joinGameWithInvitation(@PathVariable("invitationid") Long invitationId) {
        Invitation invitation = invitationRepo.findOne(invitationId);

        return new InvitationResponse(
                invitation.getPlayer().getGame().getServer().getUrl(),
                invitation.getPlayer().getGame().getId(),
                invitation.getPlayer().getControls());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    GenericResponse onError(ConstraintViolationException e) {
        return new GenericResponse("bad input", e.getMessage());
    }

}
