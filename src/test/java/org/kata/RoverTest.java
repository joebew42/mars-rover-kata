package org.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.kata.Position.at;
import static org.kata.Rover.Direction.*;

public class RoverTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void has_an_initial_position_and_a_facing_direction() {
        Rover rover = new Rover(at(1, 1), facingNorth());

        assertEquals(new Rover(at(1, 1), facingNorth()), rover);
    }

    @Test
    public void moves_north_when_it_receives_the_command_f_and_it_is_facing_north() {
        Rover rover = new Rover(at(0, 0), facingNorth());

        rover.execute('f');

        assertEquals(new Rover(at(0, 1), facingNorth()), rover);
    }

    @Test
    public void moves_south_when_it_receives_the_command_f_and_it_is_facing_south() {
        Rover rover = new Rover(at(0, 0), facingSouth());

        rover.execute('f');

        assertEquals(new Rover(at(0, -1), facingSouth()), rover);
    }

    @Test
    public void moves_east_when_it_receives_the_command_f_and_it_is_facing_east() {
        Rover rover = new Rover(at(0, 0), facingEast());

        rover.execute('f');

        assertEquals(new Rover(at(1, 0), facingEast()), rover);
    }

    @Test
    public void moves_west_when_it_receives_the_command_f_and_it_is_facing_west() {
        Rover rover = new Rover(at(0, 0), facingWest());

        rover.execute('f');

        assertEquals(new Rover(at(-1, 0), facingWest()), rover);
    }

    @Test
    public void moves_south_when_it_receives_the_command_b_and_it_is_facing_north() {
        Rover rover = new Rover(at(0, 0), facingNorth());

        rover.execute('b');

        assertEquals(new Rover(at(0, -1), facingNorth()), rover);
    }

    @Test
    public void moves_north_when_it_receives_the_command_b_and_it_is_facing_south() {
        Rover rover = new Rover(at(0, 0), facingSouth());

        rover.execute('b');

        assertEquals(new Rover(at(0, 1), facingSouth()), rover);
    }

    @Test
    public void moves_west_when_it_receives_the_command_b_and_it_is_facing_east() {
        Rover rover = new Rover(at(0, 0), facingEast());

        rover.execute('b');

        assertEquals(new Rover(at(-1, 0), facingEast()), rover);
    }

    @Test
    public void moves_east_when_it_receives_the_command_b_and_it_is_facing_west() {
        Rover rover = new Rover(at(0, 0), facingWest());

        rover.execute('b');

        assertEquals(new Rover(at(1, 0), facingWest()), rover);
    }

    @Test
    public void when_an_obstacle_is_found_it_gets_reported() {
        expectedException.expect(UnableToMoveException.class);
        expectedException.expectMessage("Obstacle encountered at: Position{x=0, y=1}");

        Rover rover = new Rover(at(0, 0), facingNorth(), withAnObstacleAt(0, 1));

        rover.execute('f');
    }

    @Test
    public void rotate_left_when_it_receives_the_command_l() {
        Rover rover = new Rover(at(0, 0), facingNorth());

        rover.execute('l');

        assertEquals(new Rover(at(0,0), facingWest()), rover);
    }

    private Obstacles withAnObstacleAt(int x, int y) {
        Obstacles obstacles = new Obstacles();
        obstacles.add(at(x, y));
        return obstacles;
    }
}
