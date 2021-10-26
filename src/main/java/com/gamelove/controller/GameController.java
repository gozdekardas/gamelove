package com.gamelove.controller;

import com.gamelove.model.Game;
import com.gamelove.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/games")
    List<Game> allNotes() {

        List<Game> games = gameService.listAllGames();
        return games;
    }
}
