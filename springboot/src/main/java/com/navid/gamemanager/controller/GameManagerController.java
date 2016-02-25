package com.navid.gamemanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navid.gamemanager.domain.*;
import com.navid.gamemanager.persistence.*;
import com.navid.gamemanager.rest.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;
import static com.navid.gamemanager.rest.AddPlayerResponse.fromPlayer;
import static com.navid.gamemanager.rest.GenericResponse.fromError;
import static com.navid.gamemanager.rest.InvitationResponse.fromUrl;

/**
 * Created by alberto on 7/19/15.
 */
@Controller
public class GameManagerController {

    private static final Logger logger = LoggerFactory.getLogger(GameManagerController.class);

    private volatile Server server;

    @Value("${gamemanager.url:ws://gamemanager.trafalgar.ws:7002}")
    private String serverExternalURL;

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

    @Resource
    private DomainMapper domainMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    private void initServer() throws MalformedURLException {
        server = serverRepo.save(new Server(serverExternalURL));
        logger.info("GameManagerController ready. Server={}", server);
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public @ResponseBody Iterable<Game> listGames() {
        logger.info("listGames invoked.");
        return gameRepo.findAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @RequestMapping(value = "/games", method = RequestMethod.PUT)
    public @ResponseBody
    GameCreationResponse createGame(@RequestBody GameCreationRequest gameInfo) {
        logger.info("createGame invoked.");
        Game game = gameRepo.save(new Game(server, gameInfo.getMap(), gameInfo.getMode(), domainMapper.convertScope(gameInfo.getScope())));
        return GameCreationResponse.fromGame(domainMapper.convertGame(game));
    }

    @RequestMapping(value = "/games/{gameid}", method = RequestMethod.GET)
    public @ResponseBody Iterable<RestPlayer> listPlayer(@PathVariable("gameid") Long gameId) {
        logger.info("listPlayer invoked.");
        return domainMapper.convertPlayers(playerRepo.findAll());
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @RequestMapping(value = "/games/{gameid}", method = RequestMethod.PUT)
    public @ResponseBody
    AddPlayerResponse addPlayer(@RequestBody AddPlayerRequest playerInfo, @PathVariable("gameid") Long gameId) {
        logger.info("addPlayer invoked.");
        Game game = gameRepo.findOne(gameId);
        Collection<Control> controls = newArrayList(controlRepo.save(domainMapper.convertControls(playerInfo.getControls())));
        Player player = playerRepo.save(new Player(game, playerInfo.getName(), playerInfo.getRole(), controls));
        Invitation invitation = invitationRepo.save(new Invitation(player));
        return fromPlayer(domainMapper.convertPlayer(player), invitation.getId());
    }

    @RequestMapping(value = "/invitation/{invitationid}", method = RequestMethod.GET)
    public @ResponseBody
    InvitationResponse joinGameWithInvitation(@PathVariable("invitationid") Long invitationId) {
        logger.info("joinGameWithInvitation invoked.");
        Invitation invitation = invitationRepo.findOne(invitationId);

        return fromUrl(
                invitation.getPlayer().getGame().getServer().getUrl(),
                invitation.getPlayer().getGame().getId(),
                domainMapper.convertControls(invitation.getPlayer().getControls()));
    }

    @RequestMapping(value = "/invitation/{invitationid}", method = RequestMethod.GET, produces = "text/html")
    public String joinGameWithInvitationWeb(@PathVariable("invitationid") Long invitationId, Model model) {
        logger.info("joinGameWithInvitationWeb invoked.");
        Invitation invitation = invitationRepo.findOne(invitationId);
        model.addAttribute("invitation", invitation);

        return "mode1";
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    GenericResponse onError(ConstraintViolationException e) {
        logger.warn("onError invoked: {}.", e.getMessage());
        return fromError("bad input", e.getMessage());
    }

}
