package com.console.insta.Games;

import org.springframework.stereotype.Component;

@Component("pacman")
public class Pacman implements  Game{
    @Override
    public void up() {
        System.out.println("Move Up!");
    }

    @Override
    public void down() {
        System.out.println("Move Down!");
    }

    @Override
    public void right() {
        System.out.println("Move Right!");
    }

    @Override
    public void left() {
        System.out.println("Move Left!");
    }
}
