package org.kata.marsrover;

public class BackwardCommand implements Command {
    @Override
    public Boolean canApply(Character commandAsCharacter) {
        return 'b' == commandAsCharacter;
    }

    @Override
    public void apply(Rover rover) {
        switch (rover.facingDirection()) {
            case NORTH:
                rover.move(Position.DOWN);
                break;
            case SOUTH:
                rover.move(Position.UP);
                break;
            case EAST:
                rover.move(Position.LEFT);
                break;
            case WEST:
                rover.move(Position.RIGHT);
                break;
        }
    }
}
