package abstractFactory.Store;

import abstractFactory.Factory.NYPizzaIngrediantFactory;
import abstractFactory.Interface.Factory.PizzaIngrediantFactory;
import abstractFactory.Pizza.CheesePizza;
import abstractFactory.Pizza.ClamPizza;
import abstractFactory.Pizza.Pizza;

public class NYPizzaStore extends PizzaStore{
    Pizza pizza = null;
    PizzaIngrediantFactory ingrediantFactory = new NYPizzaIngrediantFactory();
    @Override
    protected Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingrediantFactory);
            pizza.setName("NY Cheese Pizza");

        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingrediantFactory);
            pizza.setName("NY Clams Pizza");
        }
        return pizza;
    }
}
