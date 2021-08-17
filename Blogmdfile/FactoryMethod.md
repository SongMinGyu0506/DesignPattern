## 📗 Factory Method
앞선 글에서 기본적인 Factory 방법을 이용하여, 음식을 만드는 부분을 분리하여 만들었다.  
그 결과, 각 지점의 클래스들을 수정하지 않고 하나의 클래스로만 메뉴를 관리 할 수 있게 되었다.  
하지만, 만약 각 지점에서 메뉴들을 지점마다 다른 조리방법을 사용한다면 해당 방법을 사용할 수 없다.  
그렇다면 어떻게 해결할까? __Factory Method__ 방법을 이용하여 해결 해보도록 한다.

### 기존 팩토리 방식
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
기존에서 사용했던 코드이다. 해당 방법을 이용해야하는데 결국 공통적인 것을
하나로 묶어서 처리하면 된다.
즉, __음식을 만든다__ 라는 행동이 기존의 코드에서는 MealFactory라는 구체적인 객체로 한정되어있다.  
이것을 구체적인 객체 대신 추상화 하여 해당 메소드를 상속하게 한다음 메소드를 필요한 구현으로 만들면 될 것이다.  

### Factory Method 사용
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
해당 방식으로 소스코드를 수정했는데, 가장 상위에 있는 Restaurant 클래스는
구체적인 객체들을 이용하지 않고 전부 추상화 시켜놨다. 해당 방식을 이용함으로,
각 지점별로 음식 요리 방법을 다양하게 만들 수 있게 되었다.

## 📗 마무리
### 정의
팩토리 메서드 패턴(Factory method pattern)은 객체지향 디자인 패턴이다.
Factory method는 부모(상위) 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴이며.
자식(하위) 클래스가 어떤 객체를 생성할지를 결정하도록 하는 패턴이기도 하다. 
부모(상위) 클래스 코드에 구체 클래스 이름을 감추기 위한 방법으로도 사용한다.(위키백과)

요약하자면, 객체를 생성하는 부분 조차 구체적인 클래스를 이용하지 않음으로 더욱 다양하게 팩토리를 활용할 수 있다.

### 단점
해당 방법은 __상속__ 을 이용하는 방법으로, 잦은 상속을 사용하게 된다면 복잡하고, 특정 상위 클래스를 상속하고 있다면
Factory Method 패턴을 사용하기 어려울 수 있다. 결론은 해당 패턴은 사용하면 편리한 것은 사실이지만, 패턴에 너무 의존한다면
오히려 독이 될 수 있다.