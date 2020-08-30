package org.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.kata.Rover.Direction.*;

public class RoverTest {
    @Test
    public void has_an_initial_position_and_a_facing_direction() {
        Rover rover = new Rover(new Point(1, 1), North);

        assertEquals(new Rover(new Point(1, 1), North), rover);
    }

    @Test
    public void moves_forward_along_the_y_when_it_receives_the_command_f_and_it_is_facing_north() {
        Rover rover = new Rover(new Point(0, 0), North);

        rover.execute('f');

        assertEquals(new Rover(new Point(0, 1), North), rover);
    }

    @Test
    public void moves_backward_along_the_y_when_it_receives_the_command_f_and_it_is_facing_south() {
        Rover rover = new Rover(new Point(0, 0), South);

        rover.execute('f');

        assertEquals(new Rover(new Point(0, -1), South), rover);
    }

    @Test
    public void moves_forward_along_the_x_when_it_receives_the_command_f_and_it_is_facing_east() {
        Rover rover = new Rover(new Point(0, 0), East);

        rover.execute('f');

        assertEquals(new Rover(new Point(1, 0), East), rover);
    }
}
