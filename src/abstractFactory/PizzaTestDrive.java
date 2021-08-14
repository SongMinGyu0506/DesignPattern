package abstractFactory;

import abstractFactory.Pizza.Pizza;
import abstractFactory.Store.NYPizzaStore;
import abstractFactory.Store.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Song ordered a "+pizza+"\n");

        Pizza pizza1 = nyStore.orderPizza("clam");
        System.out.println("Song ordered a "+pizza1 + "\n");
    }
}
