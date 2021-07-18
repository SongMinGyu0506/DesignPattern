package StrategyPatternEx;

import StrategyPatternEx.Gun.Gun;
import StrategyPatternEx.Gun.GunAk47;
import StrategyPatternEx.Gun.GunAwm;
import StrategyPatternEx.ShotMode.SemiAuto;

public class ShootingSimulator {
    public static void main(String[] args) {
        Gun gun = new GunAk47();
        gun.usingBulletMode();
        gun.usingShotMode();

        Gun gun2 = new GunAwm();
        gun2.usingShotMode();
        gun2.usingBulletMode();
        gun2.setShotMode(new SemiAuto());
        gun2.usingShotMode();
    }
}
