package org.kata;

public class Commands {
    private final ForwardCommand forwardCommand = new ForwardCommand();
    private final BackwardCommand backwardCommand = new BackwardCommand();
    private final RotateLeftCommand rotateLeftCommand = new RotateLeftCommand();

    Command from(char commandCharacter) {
        if (isForwardCommand(commandCharacter)) {
            return forwardCommand;
        }
        if (isBackwardCommand(commandCharacter)) {
            return backwardCommand;
        }
        if (isRotateLeftCommand(commandCharacter)) {
            return rotateLeftCommand;
        }
        return null;
    }

    private boolean isForwardCommand(char command) {
        return 'f' == command;
    }

    private boolean isBackwardCommand(char command) {
        return 'b' == command;
    }

    private boolean isRotateLeftCommand(char command) {
        return 'l' == command;
    }
}
