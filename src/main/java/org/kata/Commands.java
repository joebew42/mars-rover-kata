package org.kata;

public class Commands {
    Command from(char commandCharacter) {
        if (isBackwardCommand(commandCharacter)) {
            return new BackwardCommand();
        }

        if (isForwardCommand(commandCharacter)) {
            return new ForwardCommand();
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
