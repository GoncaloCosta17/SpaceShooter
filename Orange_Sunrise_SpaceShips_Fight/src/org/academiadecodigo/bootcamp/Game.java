package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Random;

public class Game implements KeyboardHandler {

    private Text p1HP;
    private Text p2HP;
    private Picture menuSpaceships;
    private Picture menuButton;
    private Picture menuIntro;
    private Picture player1Wins;
    private Picture player2Wins;
    private Player1 player_1;
    private Player2 player_2;
    private boolean gameEnd = false;
    private int delay;

    // Som instanciado
    Sound sound = new Sound("resources/background2.wav");
    Sound sound1 = new Sound("resources/hit.wav");

    public Game(){
        this.delay = delay;
    }
    public void init() {
        this.keyboardInit();
        Random rand = new Random();
        delay = 2;
        Picture background = new Picture(10,10,"resources/background.jpeg");
        background.draw();

        //Jogador 1
        this.player_1 = new Player1(SpaceShipType.values()[rand.nextInt((2 - 0) + 1) + 0], 420, 600);
        this.player_1.init();

        rand = new Random();
        //Jogador 2
        this.player_2 = new Player2(SpaceShipType.values()[rand.nextInt((5 - 3) + 1) + 3], 420, 50);
        this.player_2.init();

        player1Wins = new Picture(10, 10, "resources/player1wins.png");
        player2Wins = new Picture(10,10, "resources/player2wins.png");

        p1HP = new Text(840, 380,"" + player_1.getHealth());
        p1HP.setColor(Color.WHITE);
        p1HP.grow(50,50);
        p1HP.draw();

        p2HP = new Text(840,300,"" + player_2.getHealth());
        p2HP.setColor(Color.WHITE);
        p2HP.grow(50,50);
        p2HP.draw();

        menuSpaceships = new Picture(10,10,"resources/availableSpaceshipMenu.png");
        menuSpaceships.draw();

        menuButton = new Picture(10,10,"resources/buttonComands.png");
        menuButton.draw();

        menuIntro = new Picture(10, 10, "resources/inicialMenu.png");
        menuIntro.draw();
        //musica background
        sound.play(true);
        sound.setLoop(999);
    }

    private void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(spacePressed);

        KeyboardEvent pPressed = new KeyboardEvent();
        pPressed.setKey(KeyboardEvent.KEY_P);
        pPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(pPressed);

        KeyboardEvent rPressed = new KeyboardEvent();
        rPressed.setKey(KeyboardEvent.KEY_R);
        rPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rPressed);

    }

    public void updateText(){
        p1HP.setText("" + player_1.getHealth());
        p2HP.setText("" + player_2.getHealth());
    }
    /**
     * TODO
     */
    public void checkWin() {
        if(player_1.isDestroyed()){
            player2Wins.draw();
            gameEnd = true;
        }
        if(player_2.isDestroyed()){
            player1Wins.draw();
            gameEnd = true;
        }
    }

    public void moveBullets(int direction) {
        for (int i = 0; i < player_1.getBulletsList().size(); i++) {
            Bullets bullet = player_1.getBulletsList().get(i);
            Boolean checkColision = collisionDetector(bullet);

            if(checkColision == true){
                this.player_1.getBulletsList().remove(bullet);
                bullet.removeBullet();
                this.player_2.hit(player_1.getSpaceshypType().getShipDamage());
                System.out.println(player_2.getHealth());
            }else {
                bullet.bulletMovement(direction);
            }

            Boolean checkBorder = borderDetector(bullet);
            if(checkBorder == true){
                this.player_1.getBulletsList().remove(bullet);
                bullet.removeBullet();
            }
        }
    }

    public boolean borderDetector(Bullets bullet){
        if((bullet.getY()<0) || bullet.getY()>650){
            return true;
        }
        return false;
    }


    public boolean collisionDetector(Bullets bullet){
        if((player_2.getY() == bullet.getY()+1 && (player_2.getX() <= (bullet.getBullet().getMaxX() - 30) && player_2.getPicture().getMaxX() >= (bullet.getBullet().getX()+30)))){
            sound1.play(true);
            return true;
        }
        return false;
    }

    public void moveBullets2(int direction) {
        for (int i = 0; i < player_2.getBulletsList().size(); i++) {
            Bullets bullet2 = player_2.getBulletsList().get(i);
            Boolean checkColision = collisionDetector2(bullet2);

            if(checkColision == true){
                this.player_2.getBulletsList().remove(bullet2);
                bullet2.removeBullet();
                this.player_1.hit(player_2.getSpaceshypType().getShipDamage());
            }else {
                bullet2.bulletMovement(direction);
            }
            Boolean checkBorder2 = borderDetector(bullet2);
            if (checkBorder2 == true){
                this.player_2.getBulletsList().remove(bullet2);
                bullet2.removeBullet();
            }

        }
    }
    public boolean collisionDetector2(Bullets bullet2){
        if((player_1.getY() == bullet2.getY()-1) && (player_1.getX() <=(bullet2.getBullet().getMaxX()-30) )&& player_1.getPicture().getMaxX() >= (bullet2.getBullet().getX()+30) ){
            sound1.play(true);
            player_1.hit(player_2.getSpaceshypType().getShipDamage());
            return true;
        }
        return false;
    }


    public void gameRunning() throws InterruptedException {
        while(!gameEnd){

            Thread.sleep(delay);
            //System.out.println("Objeto x: " + player_1.getX() + "| Objeto y: " + player_1.getY());
            //System.out.println("Imagem x: " + player_1.getPicture().getX() + "| Imagem y: " + player_1.getPicture().getY());
            moveBullets(-1);
            moveBullets2(1);
            updateText();
            checkWin();


        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            menuIntro.delete();
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_P){
            menuButton.delete();
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            menuSpaceships.delete();
        }

    }

}




