package com.console.insta.service;


import com.console.insta.Games.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameSelector{
    @Autowired
    private ApplicationContext context;

    public Object getSelectedGame(String game) {

        return switch (game) {
            case "pacman" -> context.getBean("pacman");
            case "mario" -> context.getBean("mario");
            case "templerun" -> context.getBean("templeRun");
            default -> context.getBean(Game.class);
        };
    }
}
