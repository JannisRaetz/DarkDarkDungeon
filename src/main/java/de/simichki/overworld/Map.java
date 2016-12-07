package de.simichki.overworld;

public class Map {
    private int width;
    private int height;
    private Field[][] fieldArray;

    public Map (Field[][] fieldArray) {
        this.width = fieldArray.length;
        this.width = fieldArray[0].length;
        this.fieldArray = fieldArray;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Field getField(int xPos, int yPos) {
        return fieldArray[xPos][yPos];
    }
}