package Singleton;

public class simulate {
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        ChocolateBoiler chocolateBoiler1 = ChocolateBoiler.getInstance();
        testClass testClass1 = new testClass();
        testClass testClass2 = new testClass();

        chocolateBoiler.fill();
        System.out.println(chocolateBoiler);
        System.out.println(chocolateBoiler1);
        System.out.println(testClass1);
        System.out.println(testClass2);
        System.out.println(chocolateBoiler1.isBoiled());
    }
}
