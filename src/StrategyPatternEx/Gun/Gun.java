package StrategyPatternEx.Gun;

import StrategyPatternEx.ShotMode.ShotMode;
import StrategyPatternEx.UsingBullet.UsingBullet;

public abstract class Gun {
    ShotMode shotMode;
    UsingBullet usingBullet;
    public Gun() {}
    public abstract void display();

    public void usingShotMode() {
        shotMode.shotmode();
    }
    public void usingBulletMode() {
        usingBullet.usingBullet();
    }

    public void setShotMode(ShotMode sm) {
        shotMode = sm;
    }
    public void setUsingBullet(UsingBullet ub) {
        usingBullet = ub;
    }
}
