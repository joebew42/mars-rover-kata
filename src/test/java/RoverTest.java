import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void a_rover_has_a_starting_point() {
        Point startingPoint = new Point(1, 1);

        Rover rover = new Rover(startingPoint);

        assertEquals(new Rover(startingPoint), rover);
    }
}
