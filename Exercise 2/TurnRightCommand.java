class TurnRightCommand implements Command {
    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public boolean execute() {
        rover.turnRight();
        return true;
    }
}
