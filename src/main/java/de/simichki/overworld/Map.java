package de.simichki.overworld;

import de.simichki.overworld.structure.Structure;

import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final Field[][] fieldArray;

    public Map (Field[][] fieldArray) {
        this.width = fieldArray.length;
        this.height = fieldArray[0].length;
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