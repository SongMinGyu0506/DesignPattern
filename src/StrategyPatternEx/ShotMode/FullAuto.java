package StrategyPatternEx.ShotMode;

public class FullAuto implements ShotMode{
    @Override
    public void shotmode() {
        System.out.println("방아쇠를 놓을 때 까지 사격");
    }
}
