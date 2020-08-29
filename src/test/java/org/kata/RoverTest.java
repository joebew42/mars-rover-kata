package org.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.kata.Rover.Direction.North;

public class RoverTest {
    @Test
    public void a_rover_has_a_starting_point() {
        Point startingPoint = new Point(1, 1);

        Rover rover = new Rover(startingPoint);

        assertEquals(new Rover(startingPoint), rover);
    }

    @Test
    public void a_rover_has_a_direction() {
        Rover rover = new Rover(North);

        assertEquals(new Rover(North), rover);
    }
}
