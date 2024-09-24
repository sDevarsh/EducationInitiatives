enum Direction {
        NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);

        int dx, dy;

        Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        }

public Direction turnLeft() {
        switch (this) {
        case NORTH: return WEST;
        case WEST: return SOUTH;
        case SOUTH: return EAST;
        case EAST: return NORTH;
        }
        return this;
        }

public Direction turnRight() {
        switch (this) {
        case NORTH: return EAST;
        case EAST: return SOUTH;
        case SOUTH: return WEST;
        case WEST: return NORTH;
        }
        return this;
        }
        }
