package Command2.Command;

import Command2.Domain.Light;

public class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
