package abstractFactory.Pizza;

import abstractFactory.Interface.Factory.PizzaIngrediantFactory;

public class ClamPizza extends Pizza {
    PizzaIngrediantFactory ingrediantFactory;


    public ClamPizza(PizzaIngrediantFactory ingrediantFactory) {
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
