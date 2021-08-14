package abstractFactory.Pizza;

import abstractFactory.Interface.Factory.PizzaIngrediantFactory;

public class CheesePizza extends Pizza{
    PizzaIngrediantFactory ingrediantFactory;
    public CheesePizza(PizzaIngrediantFactory ingrediantFactory) {
        this.ingrediantFactory = ingrediantFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing "+name);
        dough = ingrediantFactory.createDough();
        sauce = ingrediantFactory.createSource();
        cheese = ingrediantFactory.createCheese();
        clams = ingrediantFactory.createClams();
    }
}
