package abstractFactory.Pizza;

import abstractFactory.Interface.Ingrediant.Cheese;
import abstractFactory.Interface.Ingrediant.Clams;
import abstractFactory.Interface.Ingrediant.Dough;
import abstractFactory.Interface.Ingrediant.Source;

public abstract class Pizza {
    String name;

    Dough dough;
    Source sauce;
    Cheese cheese;
    Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25min at 350");
    }
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("---- "+name+" ----\n");
        if(dough != null) {
            result.append(dough);
            result.append("\n");
        }
        if(sauce != null) {
            result.append(sauce);
            result.append("\n");
        }
        if (cheese != null) {
            result.append(cheese);
            result.append("\n");
        }
        if (clams != null) {
            result.append(clams);
            result.append("\n");
        }
        return result.toString();
    }
}
