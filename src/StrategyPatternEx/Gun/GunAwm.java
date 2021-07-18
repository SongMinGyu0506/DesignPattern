package StrategyPatternEx.Gun;

import StrategyPatternEx.ShotMode.BoltAction;
import StrategyPatternEx.UsingBullet.NineMil;

public class GunAwm extends Gun{
    public GunAwm() {
        usingBullet = new NineMil();
        shotMode = new BoltAction();
    }
    @Override
    public void display() {

    }
}
