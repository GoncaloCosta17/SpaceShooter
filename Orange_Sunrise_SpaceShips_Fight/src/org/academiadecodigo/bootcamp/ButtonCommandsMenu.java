package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ButtonCommandsMenu implements KeyboardHandler {

    private Picture commandsMenu;

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        //SPACE KEY
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);

    }

    public void init() {
        commandsMenu = new Picture(10, 10, "resources/orangeSunriseSpaceshipButtonCommands.png");
        commandsMenu.draw();
        keyboardInit();
    }


    public void availableSpaceshipsMenu () {
        commandsMenu.delete();
       AvailableSpaceshipsMenu availableSpaceshipsMenu = new AvailableSpaceshipsMenu();
       availableSpaceshipsMenu.init();
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            availableSpaceshipsMenu();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}