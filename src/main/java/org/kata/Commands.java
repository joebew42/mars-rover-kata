package org.kata;

public class Commands {
    private final BackwardCommand backwardCommand = new BackwardCommand();
    private final ForwardCommand forwardCommand = new ForwardCommand();

    Command from(char commandCharacter) {
        if (isBackwardCommand(commandCharacter)) {
            return backwardCommand;
        }

        if (isForwardCommand(commandCharacter)) {
            return forwardCommand;
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
