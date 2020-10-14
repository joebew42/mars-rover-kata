package org.kata.marsrover;

public class ForwardCommand implements Command {
    @Override
    public Boolean canApply(Character commandAsCharacter) {
        return 'f' == commandAsCharacter;
    }

    @Override
    public void apply(Rover rover) {
        switch (rover.facingDirection()) {
            case NORTH:
                rover.move(Position.UP);
                break;
            case SOUTH:
                rover.move(Position.DOWN);
                break;
            case EAST:
                rover.move(Position.RIGHT);
                break;
            case WEST:
                rover.move(Position.LEFT);
                break;
        }
    }
}
