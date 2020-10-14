package org.kata.marsrover;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public static Direction facingNorth() {
        return NORTH;
    }

    public static Direction facingSouth() {
        return SOUTH;
    }

    public static Direction facingEast() {
        return EAST;
    }

    public static Direction facingWest() {
        return WEST;
    }

    public Direction rotateLeft() {
        switch (this) {
            case NORTH:
                return facingWest();
            case WEST:
                return facingSouth();
            case SOUTH:
                return facingEast();
            case EAST:
            default:
                return facingNorth();
        }
    }
}
