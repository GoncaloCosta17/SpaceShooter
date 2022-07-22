package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player2 extends SpaceShip implements KeyboardHandler {

    public Player2(SpaceShipType spaceShipType, int x, int y) {
        super(spaceShipType, x, y);
    }

    public void init(){
        this.keyboardInit();
    }


    /**
     * TODO Doc
     * Player 2 movements: A esquerda, S baixo, D direita, W cima, R disparar
     */
    private void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent dKeyPressed = new KeyboardEvent();
        dKeyPressed.setKey(KeyboardEvent.KEY_D);
        dKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(dKeyPressed);

        KeyboardEvent aKeyPressed = new KeyboardEvent();
        aKeyPressed.setKey(KeyboardEvent.KEY_A);
        aKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(aKeyPressed);

        KeyboardEvent sKeyPressed = new KeyboardEvent();
        sKeyPressed.setKey(KeyboardEvent.KEY_S);
        sKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(sKeyPressed);

        KeyboardEvent wKeyPressed = new KeyboardEvent();
        wKeyPressed.setKey(KeyboardEvent.KEY_W);
        wKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(wKeyPressed);

        KeyboardEvent vKeyPressed = new KeyboardEvent();
        vKeyPressed.setKey(KeyboardEvent.KEY_V);
        vKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(vKeyPressed);

    }

    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            if (this.getPicture().getX() <= 40) {

                this.pictureTranslate(0, 0);
            } else {
                this.setX(this.getPicture().getX());
                this.pictureTranslate(-20, 0);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            if (this.getPicture().getX() >= 785) {
                this.pictureTranslate(0, 0);
            } else {
                this.pictureTranslate(20, 0);
                this.setX(this.getPicture().getX());
            }
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            if (this.getPicture().getY() <= 60) {
                this.pictureTranslate(0, 0);
            } else {
                this.setY(this.getPicture().getY());
                this.pictureTranslate(0, -20);
            }

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            if (this.getPicture().getY() >= 250) {
                this.pictureTranslate(0, 0);
            } else {
                this.pictureTranslate(0, 20);
                this.setY(this.getPicture().getY());
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_V) {
            if((int) Math.floor(Math.random() * 10 ) % 2 == 0) {
                shoot();
            }
        }
    }
}
