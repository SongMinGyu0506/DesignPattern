package Command2.Command;

import Command2.Domain.GarageDoor;

public class GarageDoorOpen implements Command{
    GarageDoor garageDoor;
    public GarageDoorOpen(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.lightOn();
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.stop();
        garageDoor.down();
        garageDoor.lightOff();
    }
}
