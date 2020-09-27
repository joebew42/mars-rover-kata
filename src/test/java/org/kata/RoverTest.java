package org.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.kata.Rover.Direction.*;

public class RoverTest {
    @Test
    public void has_an_initial_position_and_a_facing_direction() {
        Rover rover = new Rover(new Position(1, 1), NORTH);

        assertEquals(new Rover(new Position(1, 1), NORTH), rover);
    }

    @Test
    public void moves_north_when_it_receives_the_command_f_and_it_is_facing_north() {
        Rover rover = new Rover(new Position(0, 0), NORTH);

        rover.execute('f');

        assertEquals(new Rover(new Position(0, 1), NORTH), rover);
    }

    @Test
    public void moves_south_when_it_receives_the_command_f_and_it_is_facing_south() {
        Rover rover = new Rover(new Position(0, 0), SOUTH);

        rover.execute('f');

        assertEquals(new Rover(new Position(0, -1), SOUTH), rover);
    }

    @Test
    public void moves_east_when_it_receives_the_command_f_and_it_is_facing_east() {
        Rover rover = new Rover(new Position(0, 0), EAST);

        rover.execute('f');

        assertEquals(new Rover(new Position(1, 0), EAST), rover);
    }

    @Test
    public void moves_west_when_it_receives_the_command_f_and_it_is_facing_west() {
        Rover rover = new Rover(new Position(0, 0), WEST);

        rover.execute('f');

        assertEquals(new Rover(new Position(-1, 0), WEST), rover);
    }

    @Test
    public void moves_south_when_it_receives_the_command_b_and_it_is_facing_north() {
        Rover rover = new Rover(new Position(0, 0), NORTH);

        rover.execute('b');

        assertEquals(new Rover(new Position(0, -1), NORTH), rover);
    }

    @Test
    public void moves_north_when_it_receives_the_command_b_and_it_is_facing_south() {
        Rover rover = new Rover(new Position(0, 0), SOUTH);

        rover.execute('b');

        assertEquals(new Rover(new Position(0, 1), SOUTH), rover);
    }

    @Test
    public void moves_west_when_it_receives_the_command_b_and_it_is_facing_east() {
        Rover rover = new Rover(new Position(0, 0), EAST);

        rover.execute('b');

        assertEquals(new Rover(new Position(-1, 0), EAST), rover);
    }

    @Test
    public void moves_east_when_it_receives_the_command_b_and_it_is_facing_west() {
        Rover rover = new Rover(new Position(0, 0), WEST);

        rover.execute('b');

        assertEquals(new Rover(new Position(1, 0), WEST), rover);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void when_an_obstacle_is_found_it_gets_reported() {
        expectedException.expect(UnableToMoveException.class);
        expectedException.expectMessage("Obstacle encountered at: Position{x=0, y=1}");

        Obstacles obstacles = new Obstacles();
        obstacles.add(new Position(0, 1));

        Rover rover = new Rover(new Position(0, 0), NORTH, obstacles);

        rover.execute('f');
    }
}
