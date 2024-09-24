class Rover {
    private int x, y;
    private Direction direction;
    private Grid grid;

    public Rover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public boolean moveForward() {
        int newX = x + direction.dx;
        int newY = y + direction.dy;

        if (grid.isWithinBounds(newX, newY) && !grid.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
            return true;
        } else {
            return false;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getStatus() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction.name() + ".";
    }
}
