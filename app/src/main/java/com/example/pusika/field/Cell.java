package com.example.pusika.field;

public class Cell {

    private int icon;

    public final static int WATER = 1;
    public final static int FIELD = 2;
    public final static int FOREST = 3;
    public final static int HILL = 4;
    public final static int DESERT = 5;
    public final static int ROCK = 6;
    public final static int CASTLE = 7;
    public final static int SWAMP = 8;

    public Cell(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void changeIcon() {
        if (icon == 8) {
            icon = 0;
        } else {
            icon++;
        }
    }
}
