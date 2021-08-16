## 📗 가장 기본적인 Factory
### ⚠ Factory를 사용하지 않았을 때
예를 들어서 만약 프렌차이즈 음식점을 오픈한다고 생각해보자.
서울 각 구 마다 한 지점씩... 강남점, 마포점, 용산점, 영등포점.......
상당히 많은 지점이 생길 것이다. 
```java
public class GangNam{
    //...
}
public class Mapo{
    //...
}
....
```
코드로 구현한다면 이런식으로 구현이 될 것이다. 그렇다면 이제 주문을 받아 음식을 만드는 기능을 구현해야한다.  
주문을 받고, 재료준비를 하고, 요리를 하고, 플레이팅을 하고, 서빙을 한다고 생각하자. 그리고 음식은 스테이크, 파스타 일단 두가지만 생각한다.
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
이런 식으로 코드가 작성이 될텐데, 두 클래스는 같은 코드, SRP(단일 책임 원칙)
또한 위반하고 있다. 그리고 만약 음식점에서 스테이크, 파스타 그리고 또 다른 추가 음식 10가지를 만들었다고 한다.
그렇다면 아까 위에서 서울의 각 구에 지점이 있다고 하니 25개의 클래스를 뜯어고쳐야하는 상황이다.  

몰론 해당 방식의 코드 작성이 현재 진행하는 팀에서 사용하거나 다수의 사람들이 보기 편하다면 해당 방식을 사용하지만
대다수가 해당 코드를 본다면 비효율적으로 코드를 작성했을 것이라고 말할 것이다.

그렇다면 어떻게 해당 클래스들을 수정하기 쉽고, 보기 좋게 만들 수 있을까?  
__수정이 빈번하게 일어나는 부분__ 을 따로 분리하여 만들면 된다.

### 💻 Factory를 이용한 구현
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
이렇게 수정을 한다면, 음식을 새로 추가한다고 할 때, MealFactory 클래스만 수정하면 다른 클래스를
수정할 필요 없이 음식을 추가하거나, 삭제할 수 있게 된다. 그리고 각 지점들은 __음식을 만드는 행동__ 하나만 책임을
가지게 된다.

### 🔨 마무리
해당 방법은 가장 기본적인 팩토리 이용 방법으로, 디자인 패턴중 하나라고 말할 수 는 없지만 프로그래밍을 하는데 있어서 매우 자주 사용되는 방법이고,
디자인 패턴에서 쓰이는 팩토리 메소드(Factory Method), 추상 팩토리(Abstract Method)에서 이용되는 가장 기본적인 방법이다.