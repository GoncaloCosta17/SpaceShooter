package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FinalMenu implements KeyboardHandler{

    private Picture player1wins;
    private boolean player1won;
    private Picture player2wins;
    private boolean player2won;

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        //SPACE KEY
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);

    }


    public void showPlayer1Wins() {
        keyboardInit();
        player1wins = new Picture(10,10,"resources/player1wins.png");
        player1wins.draw();
        player1won = true;
    }

    public void showPlayer2Wins() {
        keyboardInit();
        player2wins = new Picture(10,10,"resources/player2wins.png");
        player2wins.draw();
        player2won = true;
    }

    private void restartGame() throws InterruptedException {
        if (player1won == true) {
            player1wins.delete();
            StartMenu restartGame = new StartMenu();
            restartGame.init();
        }
        if (player2won == true) {
            player2wins.delete();
            StartMenu restartGame = new StartMenu();
            restartGame.init();

        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            try {
                restartGame();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
