package Command2.Command;

import Command2.Domain.CeilingFan;

public class CeilingFanOff implements Command{
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOff(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        } else if(prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if(prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if(prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        }
    }
}
