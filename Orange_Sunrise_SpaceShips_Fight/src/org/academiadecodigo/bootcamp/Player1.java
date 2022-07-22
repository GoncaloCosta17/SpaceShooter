package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player1 extends SpaceShip implements KeyboardHandler {

    public Player1(SpaceShipType spaceShipType, int x, int y) {
        super(spaceShipType, x, y);
    }

    public void init(){
        this.keyboardInit();
    }

    /**
     * Player 1 movement , up para cima, down para baixo, left para esquerda, right para a direita, M disparar.
     */
    private void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        //RIGHT KEY
        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rightKeyPressed);


        //LEFT KEY
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(leftKeyPressed);

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(downKeyPressed);

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(upKeyPressed);

        KeyboardEvent shootKeyPressed = new KeyboardEvent();
        shootKeyPressed.setKey(KeyboardEvent.KEY_M);
        shootKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(shootKeyPressed);

    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                if(this.getPicture().getX() <= 40) {
                    this.pictureTranslate(0, 0);
                }else {
                    this.pictureTranslate(-20, 0);
                    this.setX(this.getPicture().getX());
                }
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                if(this.getPicture().getX()>=785){
                    this.pictureTranslate(0, 0);
                }else {
                    this.pictureTranslate(20, 0);
                    this.setX(this.getPicture().getX());

                }
            }
            if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (this.getPicture().getY() <= 410) {
                    this.pictureTranslate(0, 0);
                } else {
                    this.pictureTranslate(0, -20);
                    this.setY(this.getPicture().getY());
                }

            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (this.getPicture().getY() >= 590) {
                    this.pictureTranslate(0, 0);
                } else {
                    this.pictureTranslate(0, 20);
                    this.setY(this.getPicture().getY());
                }
            }

            if(keyboardEvent.getKey() == KeyboardEvent.KEY_M){
                if((int) Math.floor(Math.random() * 10 ) % 2 == 0) {
                    shoot();
                }
            }
        }
    }
