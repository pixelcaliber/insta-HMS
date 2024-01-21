package com.console.insta.service;

import com.console.insta.Games.Game;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    public void run(Game selectedGame) {
        selectedGame.up();
        selectedGame.down();
        selectedGame.left();
        selectedGame.right();
    }
}
