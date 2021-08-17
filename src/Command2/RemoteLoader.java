package Command2;

import Command2.Command.*;
import Command2.Domain.CeilingFan;
import Command2.Domain.GarageDoor;
import Command2.Domain.Light;
import Command2.Domain.Stereo;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        CeilingFanOn ceilingFanOn = new CeilingFanOn(ceilingFan,1);
        CeilingFanOff ceilingFanOff = new CeilingFanOff(ceilingFan);

        GarageDoorOpen garageDoorOpen = new GarageDoorOpen(garageDoor);
        GarageDoorClose garageDoorClose = new GarageDoorClose(garageDoor);

        LightOnCommand livingRoomlightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomlightOffCommand = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        SteredOff steredOff = new SteredOff(stereo);

        Command[] partyOn = {kitchenLightOnCommand, livingRoomlightOnCommand, garageDoorOpen, stereoOnWithCDCommand, ceilingFanOn};
        Command[] partyOff = {kitchenLightOffCommand, livingRoomlightOffCommand, garageDoorClose, steredOff, ceilingFanOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(0,partyOnMacro,partyOffMacro);

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro Off ---");
        remoteControl.offButtonWasPushed(0);


//        remoteControl.setCommand(0,livingRoomlightOnCommand,livingRoomlightOffCommand);
//        remoteControl.setCommand(1,kitchenLightOnCommand,kitchenLightOffCommand);
//        remoteControl.setCommand(2,ceilingFanOn,ceilingFanOff);
//        remoteControl.setCommand(3,stereoOnWithCDCommand,steredOff);
//
//        System.out.println(remoteControl);
//
//        remoteControl.onButtonWasPushed(0);
//        remoteControl.offButtonWasPushed(0);
//        System.out.println(remoteControl);
//        remoteControl.onUndoWasPushed();
//
//        remoteControl.onButtonWasPushed(1);
//        remoteControl.offButtonWasPushed(1);
//
//        remoteControl.onButtonWasPushed(2);
//        remoteControl.offButtonWasPushed(2);
//        System.out.println(remoteControl);
//        remoteControl.onUndoWasPushed();
//
//        remoteControl.onButtonWasPushed(3);
//        remoteControl.offButtonWasPushed(3);


    }
}
