package org.kata.marsrover;

import java.util.List;

import static java.util.Arrays.asList;

public class Commands {
    private final List<Command> commands = asList(
            new ForwardCommand(),
            new BackwardCommand(),
            new RotateLeftCommand(),
            new RotateRightCommand()
    );

    Command findBy(char commandCharacter) {
        return commands.stream()
                .filter(command -> command.canApply(commandCharacter))
                .findFirst()
                .orElseGet(null);
    }
}
