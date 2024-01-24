package com.console.insta.controllers;

import com.console.insta.Games.Game;
import com.console.insta.service.GameRunner;
import com.console.insta.service.GameSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRunner gameRunner;
    @Autowired
    private GameSelector gameSelector;



    @GetMapping("/{game}")
    public Object runGame(@PathVariable String game) {

        Game selectedGame = (Game) gameSelector.getSelectedGame(game);
        gameRunner.run(selectedGame);
        return ResponseEntity.ok("Game is activated! Check the console...");
    }
}

