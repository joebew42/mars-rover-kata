package org.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.kata.Rover.Direction.North;
import static org.kata.Rover.Direction.South;

public class RoverTest {
    @Test
    public void a_rover_has_an_initial_position_and_a_facing_direction() {
        Rover rover = new Rover(new Point(1, 1), North);

        assertEquals(new Rover(new Point(1, 1), North), rover);
    }

    @Test
    public void two_rovers_with_different_initial_position_and_facing_direction_are_not_equals() {
        Rover rover = new Rover(new Point(0, 0), South);

        assertNotEquals(new Rover(new Point(1, 1), North), rover);
    }
}
