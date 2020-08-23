import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void a_rover_has_a_starting_point() {
        int x = 1;
        int y = 1;

        Rover rover = new Rover(x, y);

        assertEquals(new Rover(x,y), rover);
    }
}
