package StrategyPatternEx.ShotMode;

public class BoltAction implements ShotMode{
    @Override
    public void shotmode() {
        System.out.println("한발 쏘고 다시 장전하고...");
    }
}
