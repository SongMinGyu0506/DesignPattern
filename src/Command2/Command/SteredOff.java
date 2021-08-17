package Command2.Command;

import Command2.Domain.Stereo;

public class SteredOff implements Command{
    Stereo stereo;
    public SteredOff(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
