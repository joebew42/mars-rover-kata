package org.kata;

import java.util.HashSet;
import java.util.Set;

public class Obstacles {

    private Set<Position> obstacles = new HashSet<>();

    public void add(Position position) {
        obstacles.add(position);
    }

    public Boolean at(Position position) {
        return obstacles.contains(position);
    }
}
