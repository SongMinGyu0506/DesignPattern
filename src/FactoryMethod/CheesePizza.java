package FactoryMethod;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "CheesePizza";
        dough = "CheeseDough";
        sauce = "tomato";

        toppings.add("big cheese");
    }
}
