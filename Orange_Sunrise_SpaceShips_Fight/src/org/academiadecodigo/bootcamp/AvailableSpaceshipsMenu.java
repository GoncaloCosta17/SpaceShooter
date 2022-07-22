package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AvailableSpaceshipsMenu implements KeyboardHandler {

    private Picture spaceshipsMenu;

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        //SPACE KEY
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);

    }

    public void init() {
        spaceshipsMenu = new Picture(10 , 10 , "resources/availableSpaceshipsMenu.png");
        spaceshipsMenu.draw();
        keyboardInit();
    }

    public void startGame() throws InterruptedException {
        spaceshipsMenu.delete();
        Game game = new Game();
        game.init();
        game.gameRunning();


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            //startGame();
            }
        }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}