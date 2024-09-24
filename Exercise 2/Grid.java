import java.util.List;

class Grid {
    private int width, height;
    private boolean[][] obstacles;

    public Grid(int width, int height, List<int[]> obstacleList) {
        this.width = width;
        this.height = height;
        this.obstacles = new boolean[width][height];

        for (int[] obstacle : obstacleList) {
            obstacles[obstacle[0]][obstacle[1]] = true;
        }
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isObstacle(int x, int y) {
        return obstacles[x][y];
    }
}
