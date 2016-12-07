package de.simichki.overworld;

public enum Direction {
    TopLeft, TopRight,
    Left, Right,
    BottomLeft, BottomRight;

    public int getNumber() {
        switch (this) {
            case TopLeft: return 0;
            case TopRight: return 1;
            case Left: return 2;
            case Right: return 3;
            case BottomLeft: return 4;
            default: return 5;
        }
    }

    public static Direction getDirectionFromNumber(int number) {
        switch (number) {
            case 0: return TopLeft;
            case 1: return TopRight;
            case 2: return Left;
            case 3: return Right;
            case 4: return BottomLeft;
            default: return BottomRight;
        }
    }
}