package org.academiadecodigo.bootcamp;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class StartMenu implements KeyboardHandler {

    //BACKGROUND IMAGE
    private Picture backgroundStartMenuPicture;

    //FIRST ANIMATED SPACESHIPS
    private Picture firstAnimatedElement1;
    private Picture firstAnimatedElement2;
    private Picture firstAnimatedElement3;

    //FIRST ANIMATED SPACESHIPS
    private Picture secondAnimatedElement1;
    private Picture secondAnimatedElement2;
    private Picture secondAnimatedElement3;

    private Picture gameTitle;
    private boolean titleTextPresent;


    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        //SPACE KEY
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);

    }

    public void init () throws InterruptedException {


        keyboardInit();

        backgroundStartMenuPicture = new Picture(10, 10, "resources/backgroundStart.png");
        backgroundStartMenuPicture.draw();

        //INSTANTIATES THE 1ST GROUP OF SPACESHIPS
        firstAnimatedElement1 = new Picture(0, 20, "resources/rotatedSpaceshipBlue.png");
        firstAnimatedElement1.draw();
        firstAnimatedElement2 = new Picture(0,120,"resources/rotatedSpaceshipRed.png");
        firstAnimatedElement2.draw();
        firstAnimatedElement3 = new Picture(0,220,"resources/rotatedSpaceshipYellow.png");
        firstAnimatedElement3.draw();

        //Animations loop
        while (true) {
            Thread.sleep(10);
        if (firstAnimatedElement1.getX() >= 840) {
            firstAnimatedElement1.delete();
        } if (firstAnimatedElement2.getX() >= 840) {
            firstAnimatedElement2.delete();
        } if (firstAnimatedElement3.getX() >= 840) {
            firstAnimatedElement3.delete();

            //INSTANTIATES GAME TITLE
            gameTitle = new Picture(250,0,"resources/gameTitle.png");
            gameTitle.grow(60,60);
            gameTitle.draw();
            titleTextPresent = true;

            while (true) {
                if (gameTitle.getY() >= 100){
                    gameTitle.translate(0,0);

                    while (true){
                        //INSTANTIATES THE 2ND GROUP OF SPACESHIPS
                        secondAnimatedElement1 = new Picture(20, 550, "resources/SpaceshipBlue.png");
                        secondAnimatedElement1.draw();
                        secondAnimatedElement2 = new Picture(20,560,"resources/rotatedSpaceshipRed.png");
                        secondAnimatedElement2.draw();
                        secondAnimatedElement3 = new Picture(820,560,"resources/SpaceshipYellow.png");
                        secondAnimatedElement3.draw();

                        //MOVES THE 2ND GROUP OF SPACESHIPS
                        while (true) {
                            Thread.sleep(8);
                            if (secondAnimatedElement1.getY() <= 20) {
                                secondAnimatedElement1.delete();
                            } if (secondAnimatedElement2.getX() >= 820) {
                                secondAnimatedElement2.delete();
                            } if (secondAnimatedElement3.getY() <= 20) {
                                secondAnimatedElement3.delete();
                            } else {
                                secondAnimatedElement1.translate(0,-8);
                                secondAnimatedElement2.translate(12,0);
                                secondAnimatedElement3.translate(0,-8);
                            }
                        }
                    }
                } else {
                    //MOVES GAME TITLE ANIMATION
                    Thread.sleep(10);
                    gameTitle.translate(0,2);
                }
            }


        } else {
            //MOVES THE 1ST GROUP OF SPACESHIPS
            firstAnimatedElement1.translate(5,0);
            firstAnimatedElement2.translate(4,0);
            firstAnimatedElement3.translate(3,0);
        }
    }

}
public void buttonCommandsMenu () {
        gameTitle.delete();
        backgroundStartMenuPicture.delete();
        ButtonCommandsMenu buttonCommandsMenu = new ButtonCommandsMenu();
        buttonCommandsMenu.init();
}

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (titleTextPresent != true){
                return;
            }

            buttonCommandsMenu();

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
//Nothing
    }
}