class MoveForwardCommand implements Command {
        private Rover rover;

        public MoveForwardCommand(Rover rover) {
                this.rover = rover;
        }

        @Override
        public boolean execute() {
                return rover.moveForward();
        }
}
