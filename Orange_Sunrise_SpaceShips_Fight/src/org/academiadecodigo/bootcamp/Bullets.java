package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Bullets {

    private int x;
    private int y;
    private int bulletDamage;
    private Picture bullet;
    Sound sound = new Sound("resources/lasergun.wav");


    public Bullets(int bulletDamage,int x, int y){
        this.x = x;
        this.y = y;
        this.bulletDamage = bulletDamage;
        this.bullet = new Picture(x,y,"resources/bullet.png");
        bullet.draw();
        sound.play(true);
    }

    public void removeBullet(){
        bullet.delete();
    }

    /**
     * direcao das balas depende do jogador ser de cima ou de baixo
     * @param direction
     */
    public void bulletMovement(int direction) {

        bullet.translate(0, direction);
        this.setX(getX());
        this.setY(getY() + direction);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Picture getBullet() {
        return bullet;
    }

}
