class TurnLeftCommand implements Command {
    private Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public boolean execute() {
        rover.turnLeft();
        return true;
    }
}
