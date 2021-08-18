## Abstract Factory
앞서 살펴본 Factory는 기본적으로 객체 인스턴스를 생성하는 부분을 분리하여
관리하는 기본적인 방식을 이용하였다. Abstract Factory 패턴 또한 그 틀에서 벗어나지는 않는다.

간단하게 설명하자면, 추상 팩토리 라는 것은 특정 추상화된 객체를 이용하여 구체적인 객체들을 생성하게 한다.
해당 포스팅에서는 Interface를 이용하여 객체를 추상화한 후, 팩토리를 이용하여 객체 인스턴스를 생성하는 방법을 이용한다.

## 구현
### Domain 부분
이번 주제는 에어소프트건을 주제로 구현해본다.

```java
public abstract class Product {
    public abstract String getName();

    public abstract String getBullet();

    public String toString() {
        return "[Name :" + getName() + "Type :" + gunType() + "]";
    }
}

public class Pistol extends Product {
    private String name;
    private String bullet;

    public Pistol(String name, String bullet) {
        this.bullet = bullet;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBullet() {
        return this.bullet;
    }
}

public class AssultRifle() extends Product {
    private String name;
    private String bullet;

    public AssultRifle(String name, String bullet) {
        this.bullet = bullet;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBullet() {
        return this.bullet;
    }
}
```
### Factory 부분
하나의 최상위 팩토리를 통해서 상위 도메인을 생산할 것이므로 인터페이스를 하나 만들어서 사용하게 한다.

```java
public interface ProductCreateFactory {
    public Product createProduct();
}

public class PistolFactory implements ProductCreateFactory {
    private String name;
    private String bullet;

    public PistolFactory(String name, String bullet) {
        this.bullet = bullet;
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new Pistol(name, bullet);
    }
}

public class AssultRifleFactory implements ProductCreateFactory {
    private String name;
    private String bullet;

    public AssultRifleFactory(String name, String bullet) {
        this.bullet = bullet;
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new AssultRifle(name,bullet);
    }
}

public class ProductFactory {
    public Product createProductFactory(ProductCreateFactory productCreateFactory) {
        return productCreateFactory.createProduct();
    }
}
```

### Main
```java
public class MainSimulate {
    public static void main(String[] args) {
        Product pistol = ProductFactory.createProductFactory(new PistolFactory("Glock","9mm"));
        Product aR = ProductFactory.createProductFactory(new AssultRifleFactory("M16","5.56mm"));
        ....
    }
}
```

이러한 방식으로 구현한다면 도메인의 직접적인 접근을 하지않고 팩토리로만 객체를 생성할 수 있고,
만약 생산 공장을 구분해서 인스턴스를 생성해야한다? 그렇다면 createProduct 메소드 부분만 수정하면 된다.
예를 들어서 Pistol 부분에서 생산 업체에 따라 다른 인스턴스를 생성해야한다고 한다면 createProduct 메소드에
조건문을 붙여서 __Pistol__ 부분의 객체를 수정할 수 있게 된다.

## 마무리
이해가 잘 되지 않아서 개인적으로 어려운 패턴이었는데, 각 객체를 공통점으로 __추상화__ 하여 하나로 뭉친다음
해당 객체에서 팩토리를 이용한다.. 라는 느낌을 가지면 될 것 같다.