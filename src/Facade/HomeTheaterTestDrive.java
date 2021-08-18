package Facade;

import Facade.Domain.*;

public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier("Amp");
        CdPlayer cdPlayer = new CdPlayer("cdPlayer",amplifier);
        PopcornPopper popcornPopper = new PopcornPopper("popcornPopper");
        StreamingPlayer streamingPlayer = new StreamingPlayer("streaming",amplifier);
        Projector projector = new Projector("Projector",streamingPlayer);
        Screen screen = new Screen("Screen");
        Tuner tuner = new Tuner("tuner",amplifier);
        TheaterLights theaterLights = new TheaterLights("theaterLights");

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier,tuner,cdPlayer,projector,theaterLights,screen,popcornPopper);
        homeTheaterFacade.watchMovie("Raider of the Lost Ark");
        homeTheaterFacade.endMovie();


    }
}
