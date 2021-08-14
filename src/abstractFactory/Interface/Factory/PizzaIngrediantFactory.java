package abstractFactory.Interface.Factory;

import abstractFactory.Interface.Ingrediant.Cheese;
import abstractFactory.Interface.Ingrediant.Clams;
import abstractFactory.Interface.Ingrediant.Dough;
import abstractFactory.Interface.Ingrediant.Source;

public interface PizzaIngrediantFactory {
    public Dough createDough();
    public Source createSource();
    public Cheese createCheese();
    public Clams createClams();
}
