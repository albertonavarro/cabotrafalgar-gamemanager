package com.navid.gamemanager.controller;

import com.navid.gamemanager.domain.Game;
import com.navid.gamemanager.domain.GameCreationResult;
import com.navid.gamemanager.domain.User;
import com.navid.gamemanager.domain.UserJoinResult;
import com.navid.gamemanager.persistence.GameRepo;
import com.navid.gamemanager.persistence.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by alberto on 7/19/15.
 */
@Controller
public class GameManagerController {

    @Resource
    private GameRepo gameRepo;

    @Resource
    private UserRepo userRepo;

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public @ResponseBody Iterable<Game> listGames() {
        return gameRepo.findAll();
    }

    @RequestMapping(value = "/games", method = RequestMethod.PUT)
    public @ResponseBody GameCreationResult createGame(Game gameInfo) {
        return new GameCreationResult(){{setGame(gameRepo.save(gameInfo));}};
    }

    @RequestMapping(value = "/games/{gameid}", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> listUsers(@PathVariable("gameid") Long gameId) {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/games/{gameid}", method = RequestMethod.PUT)
    public @ResponseBody UserJoinResult joinGame(User userInfo, @PathVariable("gameid") Long gameId) {
        return new UserJoinResult(){{setGame(gameRepo.findOne(gameId)); setUser(userRepo.save(userInfo));}};
    }

}
