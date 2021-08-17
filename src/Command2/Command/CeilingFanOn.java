package Command2.Command;

import Command2.Domain.CeilingFan;

public class CeilingFanOn implements Command{
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOn(CeilingFan ceilingFan, int power) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if(prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if(prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if(prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
