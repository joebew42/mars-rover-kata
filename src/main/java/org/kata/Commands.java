package org.kata;

public class Commands {
    private final ForwardCommand forwardCommand = new ForwardCommand();
    private final BackwardCommand backwardCommand = new BackwardCommand();

    Command from(char commandCharacter) {
        if (isForwardCommand(commandCharacter)) {
            return forwardCommand;
        }
        if (isBackwardCommand(commandCharacter)) {
            return backwardCommand;
        }
        return null;
    }

    boolean isForwardCommand(char command) {
        return 'f' == command;
    }

    boolean isBackwardCommand(char command) {
        return 'b' == command;
    }
}
