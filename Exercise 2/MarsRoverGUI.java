import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarsRoverGUI extends JPanel {
    private static int gridWidth;
    private static int gridHeight;
    private static final int CELL_SIZE = 50;
    private Rover rover;
    private Grid grid;

    public MarsRoverGUI(Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid
        for (int i = 0; i <= gridWidth; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, gridHeight * CELL_SIZE);
        }
        for (int j = 0; j <= gridHeight; j++) {
            g.drawLine(0, j * CELL_SIZE, gridWidth * CELL_SIZE, j * CELL_SIZE);
        }

        // Draw obstacles
        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                if (grid.isObstacle(x, y)) {
                    g.setColor(Color.RED);
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

        // Draw rover
        g.setColor(Color.BLUE);
        g.fillOval(rover.getX() * CELL_SIZE, rover.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.BLACK);

        // Draw rover's direction
        g.drawString(rover.getDirection().name(), rover.getX() * CELL_SIZE + 15, rover.getY() * CELL_SIZE + 30);
    }

    public static void main(String[] args) {
        String gridInput = JOptionPane.showInputDialog("Enter grid size as width,height (e.g., 10,10):");
        String[] gridSize = gridInput.split(",");
        gridWidth = Integer.parseInt(gridSize[0]);
        gridHeight = Integer.parseInt(gridSize[1]);

        String positionInput = JOptionPane.showInputDialog("Enter initial position as x,y (e.g., 0,0):");
        String[] position = positionInput.split(",");
        int initialX = Integer.parseInt(position[0]);
        int initialY = Integer.parseInt(position[1]);

        String[] directions = {"NORTH", "EAST", "SOUTH", "WEST"};
        String directionInput = (String) JOptionPane.showInputDialog(null, "Select initial direction:",
                "Initial Direction", JOptionPane.QUESTION_MESSAGE, null, directions, directions[0]);
        Direction initialDirection = Direction.valueOf(directionInput);

        List<int[]> obstacles = new ArrayList<>();
        String obstacleInput = JOptionPane.showInputDialog("Enter obstacles as x1,y1;x2,y2 (e.g., 2,2;3,3):");
        if(!Objects.equals(obstacleInput, "")){
            String[] obstaclePairs = obstacleInput.split(";");

            try {
                for (String pair : obstaclePairs) {
                    String[] coords = pair.split(",");
                    int obstacleX = Integer.parseInt(coords[0]);
                    int obstacleY = Integer.parseInt(coords[1]);

                    if (initialX == obstacleX && initialY == obstacleY) {
                        throw new IllegalArgumentException("Obstacle cannot be placed at the rover's initial position (" + initialX + ", " + initialY + ").");
                    }
                    obstacles.add(new int[]{obstacleX, obstacleY});
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Obstacle Placement", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input for obstacles. Please enter valid coordinates.", "Input Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }

        Grid grid = new Grid(gridWidth, gridHeight, obstacles);
        Rover rover = new Rover(initialX, initialY, initialDirection, grid); // Use the initial direction

        JFrame frame = new JFrame("Mars Rover Simulation with User Input");
        MarsRoverGUI panel = new MarsRoverGUI(rover, grid);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        JTextField commandField = new JTextField(20);
        JButton submitButton = new JButton("Move Rover");

        inputPanel.add(new JLabel("Enter Commands (M, L, R): "));
        inputPanel.add(commandField);
        inputPanel.add(submitButton);
        frame.add(inputPanel, BorderLayout.SOUTH);
        if(gridHeight <= 6)
            frame.setSize(700, 400);
        else
            frame.setSize(gridWidth * CELL_SIZE + 150, gridHeight * CELL_SIZE + 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commands = commandField.getText().trim().toUpperCase();
                for (char command : commands.toCharArray()) {
                    boolean success = false;
                    switch (command) {
                        case 'M':
                            success = new MoveForwardCommand(rover).execute();
                            break;
                        case 'L':
                            success = new TurnLeftCommand(rover).execute();
                            break;
                        case 'R':
                            success = new TurnRightCommand(rover).execute();
                            break;
                    }

                    if (!success) {
                        JOptionPane.showMessageDialog(frame, "Move blocked by an obstacle or out of bounds!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                commandField.setText("");
                panel.repaint();
            }
        });
    }
}
