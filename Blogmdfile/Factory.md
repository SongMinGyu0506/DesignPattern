## π κ°μ₯ κΈ°λ³Έμ μΈ Factory
### β  Factoryλ₯Ό μ¬μ©νμ§ μμμ λ
μλ₯Ό λ€μ΄μ λ§μ½ νλ μ°¨μ΄μ¦ μμμ μ μ€ννλ€κ³  μκ°ν΄λ³΄μ.
μμΈ κ° κ΅¬ λ§λ€ ν μ§μ μ©... κ°λ¨μ , λ§ν¬μ , μ©μ°μ , μλ±ν¬μ .......
μλΉν λ§μ μ§μ μ΄ μκΈΈ κ²μ΄λ€. 
```java
public class GangNam{
    //...
}
public class Mapo{
    //...
}
....
```
μ½λλ‘ κ΅¬ννλ€λ©΄ μ΄λ°μμΌλ‘ κ΅¬νμ΄ λ  κ²μ΄λ€. κ·Έλ λ€λ©΄ μ΄μ  μ£Όλ¬Έμ λ°μ μμμ λ§λλ κΈ°λ₯μ κ΅¬νν΄μΌνλ€.  
μ£Όλ¬Έμ λ°κ³ , μ¬λ£μ€λΉλ₯Ό νκ³ , μλ¦¬λ₯Ό νκ³ , νλ μ΄νμ νκ³ , μλΉμ νλ€κ³  μκ°νμ. κ·Έλ¦¬κ³  μμμ μ€νμ΄ν¬, νμ€ν μΌλ¨ λκ°μ§λ§ μκ°νλ€.
```java
...
public class GangNam {
    public Meal orderMeal(String order) {
        Meal meal;
        if (order.equals("steak")) {
            meal = new Steak();
        } else if(order.equals("pasta")) {
            meal = new Pasta();
        }
        meal.prepare();
        meal.cook();
        meal.plating();
        meal.serving();
        return Meal;
    }
}
public class Mapo {
    public Meal orderMeal(String order) {
        Meal meal;
        if (order.equals("steak")) {
            meal = new Steak();
        } else if(order.equals("pasta")) {
            meal = new Pasta();
        }
        meal.prepare();
        meal.cook();
        meal.plating();
        meal.serving();
        return Meal;
    }
}
...
```
μ΄λ° μμΌλ‘ μ½λκ° μμ±μ΄ λ νλ°, λ ν΄λμ€λ κ°μ μ½λ, SRP(λ¨μΌ μ±μ μμΉ)
λν μλ°νκ³  μλ€. κ·Έλ¦¬κ³  λ§μ½ μμμ μμ μ€νμ΄ν¬, νμ€ν κ·Έλ¦¬κ³  λ λ€λ₯Έ μΆκ° μμ 10κ°μ§λ₯Ό λ§λ€μλ€κ³  νλ€.
κ·Έλ λ€λ©΄ μκΉ μμμ μμΈμ κ° κ΅¬μ μ§μ μ΄ μλ€κ³  νλ 25κ°μ ν΄λμ€λ₯Ό λ―μ΄κ³ μ³μΌνλ μν©μ΄λ€.  

λͺ°λ‘  ν΄λΉ λ°©μμ μ½λ μμ±μ΄ νμ¬ μ§ννλ νμμ μ¬μ©νκ±°λ λ€μμ μ¬λλ€μ΄ λ³΄κΈ° νΈνλ€λ©΄ ν΄λΉ λ°©μμ μ¬μ©νμ§λ§
λλ€μκ° ν΄λΉ μ½λλ₯Ό λ³Έλ€λ©΄ λΉν¨μ¨μ μΌλ‘ μ½λλ₯Ό μμ±νμ κ²μ΄λΌκ³  λ§ν  κ²μ΄λ€.

κ·Έλ λ€λ©΄ μ΄λ»κ² ν΄λΉ ν΄λμ€λ€μ μμ νκΈ° μ½κ³ , λ³΄κΈ° μ’κ² λ§λ€ μ μμκΉ?  
__μμ μ΄ λΉλ²νκ² μΌμ΄λλ λΆλΆ__ μ λ°λ‘ λΆλ¦¬νμ¬ λ§λ€λ©΄ λλ€.

### π» Factoryλ₯Ό μ΄μ©ν κ΅¬ν
```java
public class MealFactory {
    public Meal createMeal(String order) {
        Meal meal = null;
        if (order.equals("steak")) {
            meal = new Steak();
        } else if (order.equals("pasta")) {
            meal = new Pasta();
        } else if (order.equals("risotto")) {
            meal = new Resotto();
        } else if (order.equals("coffee")) {
            meal = new Coffee();
        } else if (order.equals("wine")) {
            meal = new Wine();
        }
    }
}

public class GangNam {
    MealFactory mealFactory;
    public GangNam(MealFactory mealFactory) {
        this.mealFactory = mealFactory;
    }
    public Meal orderMeal(String order) {
        Meal meal = mealFactory.createMeal(order);
        meal.prepare();
        meal.cook();
        meal.plating();
        meal.serving();
    }
}

public class Mapo {
    MealFactory mealFactory;
    public Mapo(MealFactory mealFactory) {
        this.mealFactory = mealFactory;
    }
    public Meal orderMeal(String order) {
        Meal meal = mealFactory.createMeal(order);
        meal.prepare();
        meal.cook();
        meal.plating();
        meal.serving();
    }
}
```
μ΄λ κ² μμ μ νλ€λ©΄, μμμ μλ‘ μΆκ°νλ€κ³  ν  λ, MealFactory ν΄λμ€λ§ μμ νλ©΄ λ€λ₯Έ ν΄λμ€λ₯Ό
μμ ν  νμ μμ΄ μμμ μΆκ°νκ±°λ, μ­μ ν  μ μκ² λλ€. κ·Έλ¦¬κ³  κ° μ§μ λ€μ __μμμ λ§λλ νλ__ νλλ§ μ±μμ
κ°μ§κ² λλ€.

### π¨ λ§λ¬΄λ¦¬
ν΄λΉ λ°©λ²μ κ°μ₯ κΈ°λ³Έμ μΈ ν©ν λ¦¬ μ΄μ© λ°©λ²μΌλ‘, λμμΈ ν¨ν΄μ€ νλλΌκ³  λ§ν  μ λ μμ§λ§ νλ‘κ·Έλλ°μ νλλ° μμ΄μ λ§€μ° μμ£Ό μ¬μ©λλ λ°©λ²μ΄κ³ ,
λμμΈ ν¨ν΄μμ μ°μ΄λ ν©ν λ¦¬ λ©μλ(Factory Method), μΆμ ν©ν λ¦¬(Abstract Method)μμ μ΄μ©λλ κ°μ₯ κΈ°λ³Έμ μΈ λ°©λ²μ΄λ€.