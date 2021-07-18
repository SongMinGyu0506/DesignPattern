package StrategyPatternEx.ShotMode;

public class TripleAuto implements ShotMode{
    @Override
    public void shotmode() {
        System.out.println("방아쇠 한번에 세발씩");
    }
}
