package org.academiadecodigo.bootcamp;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //StartMenu startMenu = new StartMenu();
        //startMenu.init();

        Game game = new Game();
        game.init();
        game.gameRunning();
    }
}