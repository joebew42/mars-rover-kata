package org.kata.marsrover;

import java.util.List;

import static java.util.Arrays.asList;

public class DefaultCommands {
    public static final List<Command> all = asList(
            new ForwardCommand(),
            new BackwardCommand(),
            new RotateLeftCommand()
    );
}
