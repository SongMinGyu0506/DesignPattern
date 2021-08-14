package abstractFactory.Factory;

import abstractFactory.Ingrediant.FreshClams;
import abstractFactory.Ingrediant.MarinaraSauce;
import abstractFactory.Ingrediant.ReggianoCheese;
import abstractFactory.Ingrediant.ThinCrustDough;
import abstractFactory.Interface.Factory.PizzaIngrediantFactory;
import abstractFactory.Interface.Ingrediant.Cheese;
import abstractFactory.Interface.Ingrediant.Clams;
import abstractFactory.Interface.Ingrediant.Dough;
import abstractFactory.Interface.Ingrediant.Source;

public class NYPizzaIngrediantFactory implements PizzaIngrediantFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Source createSource() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
