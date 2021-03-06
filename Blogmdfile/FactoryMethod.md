## ๐ Factory Method
์์  ๊ธ์์ ๊ธฐ๋ณธ์ ์ธ Factory ๋ฐฉ๋ฒ์ ์ด์ฉํ์ฌ, ์์์ ๋ง๋๋ ๋ถ๋ถ์ ๋ถ๋ฆฌํ์ฌ ๋ง๋ค์๋ค.  
๊ทธ ๊ฒฐ๊ณผ, ๊ฐ ์ง์ ์ ํด๋์ค๋ค์ ์์ ํ์ง ์๊ณ  ํ๋์ ํด๋์ค๋ก๋ง ๋ฉ๋ด๋ฅผ ๊ด๋ฆฌ ํ  ์ ์๊ฒ ๋์๋ค.  
ํ์ง๋ง, ๋ง์ฝ ๊ฐ ์ง์ ์์ ๋ฉ๋ด๋ค์ ์ง์ ๋ง๋ค ๋ค๋ฅธ ์กฐ๋ฆฌ๋ฐฉ๋ฒ์ ์ฌ์ฉํ๋ค๋ฉด ํด๋น ๋ฐฉ๋ฒ์ ์ฌ์ฉํ  ์ ์๋ค.  
๊ทธ๋ ๋ค๋ฉด ์ด๋ป๊ฒ ํด๊ฒฐํ ๊น? __Factory Method__ ๋ฐฉ๋ฒ์ ์ด์ฉํ์ฌ ํด๊ฒฐ ํด๋ณด๋๋ก ํ๋ค.

### ๊ธฐ์กด ํฉํ ๋ฆฌ ๋ฐฉ์
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
        return meal;
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
        return meal;
    }
}
```
๊ธฐ์กด์์ ์ฌ์ฉํ๋ ์ฝ๋์ด๋ค. ํด๋น ๋ฐฉ๋ฒ์ ์ด์ฉํด์ผํ๋๋ฐ ๊ฒฐ๊ตญ ๊ณตํต์ ์ธ ๊ฒ์
ํ๋๋ก ๋ฌถ์ด์ ์ฒ๋ฆฌํ๋ฉด ๋๋ค.
์ฆ, __์์์ ๋ง๋ ๋ค__ ๋ผ๋ ํ๋์ด ๊ธฐ์กด์ ์ฝ๋์์๋ MealFactory๋ผ๋ ๊ตฌ์ฒด์ ์ธ ๊ฐ์ฒด๋ก ํ์ ๋์ด์๋ค.  
์ด๊ฒ์ ๊ตฌ์ฒด์ ์ธ ๊ฐ์ฒด ๋์  ์ถ์ํ ํ์ฌ ํด๋น ๋ฉ์๋๋ฅผ ์์ํ๊ฒ ํ๋ค์ ๋ฉ์๋๋ฅผ ํ์ํ ๊ตฌํ์ผ๋ก ๋ง๋ค๋ฉด ๋  ๊ฒ์ด๋ค.  

### Factory Method ์ฌ์ฉ
```java
public abstract class Restaurant {
    public Meal orderMeal(String order) {
        Meal meal;
        meal = createMeal(order);
        
        meal.prepare();
        meal.cook();
        meal.plating();
        meal.serving();
        
        return meal;
    } 
    public abstract Meal createMeal(String order);
}

public class Gangnam extends Restaurant {
    @Override
    public Meal createMeal(String order) {
        if (order.equals("GNSteak")) {
            return new GNSteak();
        } else if(order.equals("GNPasta")) {
            return new GNPasta();
        } else if(order.equals("GNRissoto")) {
            return new GNRissoto();
        } else if(order.equals("GNCoffee")) {
            return new GNCoffee();
        } else if(order.equals("GNWine")) {
            return new GNWine();
        }
    }
}

public class Mapo extends Restaurant {
    @Override
    public Meal createMeal(String order) {
        if (order.equals("MPSteak")) {
            return new MPSteak();
        } else if(order.equals("MPPasta")) {
            return new MPPasta();
        } else if(order.equals("MPRissoto")) {
            return new MPRissoto();
        } else if(order.equals("MPCoffee")) {
            return new MPCoffee();
        } else if(order.equals("MPWine")) {
            return new MPWine();
        }
    }
}

public class MealSimulate {
    public static void main(String[] args) {
        Restaurant gangnamRes = new Gangnam();
        Restaurant mapoRes = new Mapo();
        Meal meal1 = gangnamRes.orderMeal("GNSteak");
        Meal meal2 = mapoRes.orderMeal("MPSteak");
    }
}
```
ํด๋น ๋ฐฉ์์ผ๋ก ์์ค์ฝ๋๋ฅผ ์์ ํ๋๋ฐ, ๊ฐ์ฅ ์์์ ์๋ Restaurant ํด๋์ค๋
๊ตฌ์ฒด์ ์ธ ๊ฐ์ฒด๋ค์ ์ด์ฉํ์ง ์๊ณ  ์ ๋ถ ์ถ์ํ ์์ผ๋จ๋ค. ํด๋น ๋ฐฉ์์ ์ด์ฉํจ์ผ๋ก,
๊ฐ ์ง์ ๋ณ๋ก ์์ ์๋ฆฌ ๋ฐฉ๋ฒ์ ๋ค์ํ๊ฒ ๋ง๋ค ์ ์๊ฒ ๋์๋ค.

## ๐ ๋ง๋ฌด๋ฆฌ
### ์ ์
ํฉํ ๋ฆฌ ๋ฉ์๋ ํจํด(Factory method pattern)์ ๊ฐ์ฒด์งํฅ ๋์์ธ ํจํด์ด๋ค.
Factory method๋ ๋ถ๋ชจ(์์) ํด๋์ค์ ์๋ ค์ง์ง ์์ ๊ตฌ์ฒด ํด๋์ค๋ฅผ ์์ฑํ๋ ํจํด์ด๋ฉฐ.
์์(ํ์) ํด๋์ค๊ฐ ์ด๋ค ๊ฐ์ฒด๋ฅผ ์์ฑํ ์ง๋ฅผ ๊ฒฐ์ ํ๋๋ก ํ๋ ํจํด์ด๊ธฐ๋ ํ๋ค. 
๋ถ๋ชจ(์์) ํด๋์ค ์ฝ๋์ ๊ตฌ์ฒด ํด๋์ค ์ด๋ฆ์ ๊ฐ์ถ๊ธฐ ์ํ ๋ฐฉ๋ฒ์ผ๋ก๋ ์ฌ์ฉํ๋ค.(์ํค๋ฐฑ๊ณผ)

์์ฝํ์๋ฉด, ๊ฐ์ฒด๋ฅผ ์์ฑํ๋ ๋ถ๋ถ ์กฐ์ฐจ ๊ตฌ์ฒด์ ์ธ ํด๋์ค๋ฅผ ์ด์ฉํ์ง ์์์ผ๋ก ๋์ฑ ๋ค์ํ๊ฒ ํฉํ ๋ฆฌ๋ฅผ ํ์ฉํ  ์ ์๋ค.

### ๋จ์ 
ํด๋น ๋ฐฉ๋ฒ์ __์์__ ์ ์ด์ฉํ๋ ๋ฐฉ๋ฒ์ผ๋ก, ์ฆ์ ์์์ ์ฌ์ฉํ๊ฒ ๋๋ค๋ฉด ๋ณต์กํ๊ณ , ํน์  ์์ ํด๋์ค๋ฅผ ์์ํ๊ณ  ์๋ค๋ฉด
Factory Method ํจํด์ ์ฌ์ฉํ๊ธฐ ์ด๋ ค์ธ ์ ์๋ค. ๊ฒฐ๋ก ์ ํด๋น ํจํด์ ์ฌ์ฉํ๋ฉด ํธ๋ฆฌํ ๊ฒ์ ์ฌ์ค์ด์ง๋ง, ํจํด์ ๋๋ฌด ์์กดํ๋ค๋ฉด
์คํ๋ ค ๋์ด ๋  ์ ์๋ค.