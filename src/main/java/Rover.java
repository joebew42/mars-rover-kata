import java.util.Objects;

public class Rover {
    private final int x;
    private final int y;

    public Rover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
