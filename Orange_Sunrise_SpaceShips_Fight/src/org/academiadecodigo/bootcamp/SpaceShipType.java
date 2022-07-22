package org.academiadecodigo.bootcamp;

/**
 * Enum com os tipos de naves do jogo!
 */
public enum SpaceShipType {

    FIRESHIP_A(120, 8, "resources/SpaceshipRed.png"),
    LIGHTSHIP_A(80, 12, "resources/SpaceshipYellow.png"),
    WATERSHIP_A(100, 10, "resources/SpaceshipBlue.png"),

    FIRESHIP_B(120, 8, "resources/SpaceshipRedDown.png"),
    LIGHTSHIP_B(80, 12, "resources/SpaceshipYellowDown.png"),
    WATERSHIP_B(100, 10, "resources/SpaceshipBlueDown.png");

    private final int health;

    private final int damage;

    private final String pictureFile;

    SpaceShipType(int health, int damage, String pictureFile) {
        this.health = health;
        this.damage = damage;
        this.pictureFile = pictureFile;
    }

    public int getShipHealth() {
        return this.health;
    }

    public int getShipDamage() {
        return this.damage;
    }

    public String getPictureFile(){
        return this.pictureFile;
    }

}
