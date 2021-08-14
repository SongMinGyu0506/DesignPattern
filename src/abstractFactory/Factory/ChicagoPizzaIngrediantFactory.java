package abstractFactory.Factory;

import abstractFactory.Ingrediant.FrozenClams;
import abstractFactory.Ingrediant.MozzarellaCheese;
import abstractFactory.Ingrediant.PlumTomatoSauce;
import abstractFactory.Ingrediant.ThickCrustDough;
import abstractFactory.Interface.Factory.PizzaIngrediantFactory;
import abstractFactory.Interface.Ingrediant.Cheese;
import abstractFactory.Interface.Ingrediant.Clams;
import abstractFactory.Interface.Ingrediant.Dough;
import abstractFactory.Interface.Ingrediant.Source;

public class ChicagoPizzaIngrediantFactory implements PizzaIngrediantFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Source createSource() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
