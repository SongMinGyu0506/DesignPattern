package StrategyPattern.Duck;

import StrategyPattern.FlyBehavior.FlyWithWings;
import StrategyPattern.QuackBehavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {

    }
}
