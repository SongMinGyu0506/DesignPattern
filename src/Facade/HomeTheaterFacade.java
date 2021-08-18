package Facade;

import Facade.Domain.*;

public class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    CdPlayer cd;
    Projector projector;
    TheaterLights theaterLights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp, Tuner tuner, CdPlayer cd, Projector projector, TheaterLights theaterLights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.cd = cd;
        this.projector = projector;
        this.theaterLights = theaterLights;
        this.screen = screen;
        this.popper = popper;
    }
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        theaterLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setStereoSound();
        amp.setVolume(5);
        cd.on();
        cd.play(movie);
    }
    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amp.off();
        cd.stop();
        cd.eject();
        cd.off();
    }
}
