package Command2.Command;

import Command2.Domain.GarageDoor;

public class GarageDoorClose implements Command{
    GarageDoor garageDoor;
    public GarageDoorClose(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.stop();
        garageDoor.down();
        garageDoor.lightOff();
    }

    @Override
    public void undo() {
        garageDoor.lightOn();
        garageDoor.up();
    }
}
