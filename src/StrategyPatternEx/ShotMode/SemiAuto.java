package StrategyPatternEx.ShotMode;

public class SemiAuto implements ShotMode{
    @Override
    public void shotmode() {
        System.out.println("방아쇠 한번에 한발씩");
    }
}
