package org.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.kata.Rover.Direction.North;

public class RoverTest {
    @Test
    public void a_rover_has_an_initial_position_and_a_facing_direction() {
        Rover rover = new Rover(new Point(1, 1), North);

        assertEquals(new Rover(new Point(1, 1), North), rover);
    }
}
