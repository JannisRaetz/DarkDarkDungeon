package de.simichki.overworld;

public class Field {
    private int xPos;
    private int yPos;
    private FieldType fieldType;
    private Structure structure;

    public Field(int xPos, int yPos, FieldType fieldType) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.fieldType = fieldType;
    }

    public Field getNeighbour(Direction direction) {
        return null;
    }

}
