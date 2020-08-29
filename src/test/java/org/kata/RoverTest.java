package org.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.kata.Rover.Direction.North;
import static org.kata.Rover.Direction.South;

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

    @Test
    public void two_rovers_with_different_directions_are_not_equals() {
        Rover rover = new Rover(South);

        assertNotEquals(new Rover(North), rover);
    }
}
