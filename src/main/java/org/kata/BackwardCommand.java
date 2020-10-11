package org.kata;

import static org.kata.Position.*;

public class BackwardCommand implements Command {
    @Override
    public void apply(Rover rover) {
        switch (rover.facingDirection()) {
            case NORTH:
                rover.move(DOWN);
                break;
            case SOUTH:
                rover.move(UP);
                break;
            case EAST:
                rover.move(LEFT);
                break;
            case WEST:
                rover.move(RIGHT);
                break;
        }
    }
}
