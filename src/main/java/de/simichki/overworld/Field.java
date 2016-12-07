package de.simichki.overworld;

import de.simichki.overworld.structure.Structure;

public class Field {
    private final int xPos;
    private final int yPos;
    private final FieldType fieldType;

    private Structure structure;
    //private Force force;

    public Field(int xPos, int yPos, FieldType fieldType) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.fieldType = fieldType;
    }

    public Structure getStructure() {
        return this.structure;
    }

    public void setStructure() {
        this.structure = structure;
    }

}
