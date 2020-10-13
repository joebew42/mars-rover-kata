package org.kata;

import static org.kata.Position.*;

public class ForwardCommand implements Command {
    @Override
    public Boolean canApply(Character commandAsCharacter) {
        return 'f' == commandAsCharacter;
    }

    @Override
    public void apply(Rover rover) {
        switch (rover.facingDirection()) {
            case NORTH:
                rover.move(UP);
                break;
            case SOUTH:
                rover.move(DOWN);
                break;
            case EAST:
                rover.move(RIGHT);
                break;
            case WEST:
                rover.move(LEFT);
                break;
        }
    }
}
