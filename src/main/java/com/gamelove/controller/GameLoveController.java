package com.gamelove.controller;

import com.gamelove.model.GameLove;
import com.gamelove.service.GameLoveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class GameLoveController {

    @Autowired
    GameLoveService gameLoveService;

    //fetch all games a player have loved.
    @GetMapping("/games/{userId}")
    List<GameLove> retrieveGames(@PathVariable int userId) {

        List<GameLove> games = gameLoveService.findByUserId(userId);
        return games;
    }

    //to create a new entry with player and the game
    @PostMapping("/addGameLove")
    public ResponseEntity<String> add(@RequestBody GameLove gameLove) {

        int cnt = gameLoveService.checkIfExists(gameLove.getUserId(),gameLove.getGameId());

        if(cnt == 0) {
            int loveId = gameLoveService.saveLovedGame(gameLove);
            return ResponseEntity.ok(loveId + ": id, game loved by user");
        }else
            return ResponseEntity.ok("game and user love already exists");
    }


    //to unlove games with love identifier
    @DeleteMapping("/deleteLove/{loveId}")
    void deleteLove(@PathVariable int loveId) {
        gameLoveService.deleteFromLoved(loveId);
    }


    //fetch most loved games by top parameter
    @GetMapping("/getTopGames/{top}")
    List<Object[]> retrieveTopGames(@PathVariable int top) {
        List<Object[]> topGames;
        try {
            topGames = gameLoveService.getTopGames(top);
        } catch (Exception e) {
            topGames = null;
        }
        return topGames;
    }
}
