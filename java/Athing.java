package src.main.java;

import java.util.Objects;

public class Athing {
    private String name;

    public int mapPositionY;

    public int mappositionX;


    public Athing( int positionInX, int PositionInY,String name) {
        this.mappositionX = positionInX;
        this.mapPositionY = PositionInY;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosX() {
        return mappositionX;
    }

    public int getPosY() {
        return mapPositionY;
    }



}

