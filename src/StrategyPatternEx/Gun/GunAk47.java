package StrategyPatternEx.Gun;

import StrategyPatternEx.ShotMode.FullAuto;
import StrategyPatternEx.UsingBullet.FiveFiveSixmil;

public class GunAk47 extends Gun{
    public GunAk47() {
        shotMode = new FullAuto();
        usingBullet = new FiveFiveSixmil();
    }
    @Override
    public void display() {

    }
}
