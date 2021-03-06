## ๐ชข Observer ํจํด - Java.util ์ฌ์ฉ

## โฑ ์๋ก 
๊ธฐ์กด์ ์ต์ ๋ฒ ํจํด ํฌ์คํ์์๋ ์ง์  ์ต์ ๋ฒ, ์ฃผ์ ์ ๋ํ ์ธํฐํ์ด์ค๋ฅผ ๋ง๋ค์ด ๋์จํ ์ฐ๊ฒฐ๋ก ๊ด๋ฆฌํ๋๋ก ๋ง๋ค์๋ค.  

Java util ์์ ํด๋น ์์์ ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ก ๋ง๋ค์ด๋์ ๊ฒ์ด ์๊ณ , ์ด๋ฒ ํฌ์คํ์์๋ ํด๋น ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ฅผ ์ด์ฉํ์ฌ
Observer ํจํด์ ์ค์ตํด๋ณธ๋ค.

## ๐ฅ ๊ตฌํ
### ์ฃผ์ (Subject) ๋ถ๋ถ
```java
//Java.util Observer pattern
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChange() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChange();
    }
    // Getter/Setter ...
}
```
```java
//๊ธฐ์กด์ ์ต์ ๋ฒ ํจํด
public class WeatherData implements Subject {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i=0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
```
ํ์คํ ๋ณด์ด๋ ๊ฒ์, ๊ธฐ์กด ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ฅผ ํ์ฉํ ์ต์ ๋ฒ ํจํด์ ๋ผ์ธ์ด ์๋นํ ์ค์ด๋ค์์์ ๋ณผ ์ ์๋ค.  
๊ทธ๋ฆฌ๊ณ  ์ค๋ฒ๋ผ์ด๋ ๋ ๋ถ๋ถ ์ฆ, ๊ธฐ์กด์ Observer Interface์ ๋ถ๋ถ์ ์ ๋ถ ์๋ฐ ๋ผ์ด๋ธ๋ฌ๋ฆฌ๊ฐ ๋ด๋นํ๊ณ  ์๋ค.  

### ์๋ ๋ฐฉ์
#### ๊ฐ์ฒด๊ฐ ์ต์ ๋ฒ๊ฐ ๋๋ ๋ฐฉ๋ฒ
๊ธฐ์กด์ ์ต์ ๋ฒ ํจํด์์๋ ์ง์  registerObserver ๋ฉ์๋๋ฅผ ํธ์ถํ์ฌ ArrayList์ ๋ฑ๋กํ๋ ๋ฐฉ์์ด์์ง๋ง,  
์๋ฐ ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ฅผ ํ์ฉํ ๋ฐฉ์์์๋ ์ต์ ๋ฒ ์ธํฐํ์ด์ค์ addObserver ๋ฉ์๋๋ฅผ ํธ์ถํ์ฌ ๋ฑ๋กํ๋ค.

#### Observable์์ ์ฐ๋ฝ์ ๋๋ฆฌ๋ ๋ฐฉ๋ฒ
__Observable ์ด๋?__  
๋จ์ด ์์ฒด๋ฅผ ํด์ํ๋ฉด ๊ด์ฐฐ ํ  ์ ์๋, ์ฃผ๋ชฉํ ๋งํ ์ด๋ผ๋ ๋ป์ ๋จ์ด์ธ๋ฐ ์ฃผ์ ๊ฐ ๋  ๊ฐ์ฒด์ ์ฌ์ฉํ๋ค.  
Observable ํด๋์ค์์ setChanged ๋ฉ์๋๋ฅผ ํธ์ถํ์ฌ ๊ฐ์ฒด์ ์ํ๊ฐ ๋ฐ๋์๋ค๋ ๊ฒ์ ๋จผ์  ์๋ฆฐ๋ค.  
๊ทธ๋ฆฌ๊ณ  notifyObservers(), notifyObservers(Object arg)๋ฅผ ์ด์ฉํ์ฌ ์ ๋ฌํ๋ค.

#### Observer๊ฐ ์ฐ๋ฝ์ ๋ฐ๋ ๋ฐฉ๋ฒ
```java
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+temperature+"F degrees and "+humidity+ "% humidity");
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
```
๊ธฐ์กด์ ๋ฐฉ์๊ณผ ๊ฐ์ด update ๋ฉ์๋๋ฅผ ์ด์ฉํ๋ค.  
ํ์ง๋ง ๋ฉ์๋์ ํ๋ผ๋ฏธํฐ๊ฐ ์กฐ๊ธ ๋ค๋ฅธ ๊ฒ์ ๋ณผ ์ ์๋๋ฐ, 
์ฒซ ๋ฒ์งธ ํ๋ผ๋ฏธํฐ๊ฐ ์ด๋ค ์ฃผ์ , ๋๋ฒ์งธ ํ๋ผ๋ฏธํฐ๊ฐ notifyObserver์์ ์ ๋ฌ๋ ๋ฐ์ดํฐ์ด๋ค.

์ฆ, ์ ๋ฆฌํ์๋ฉด ์ฃผ์  ๊ฐ์ฒด์์ setChange() -> notifyObserver() -> update() -> display() ์์๋ก ์งํ๋๋ค.  
์ฌ๊ธฐ์ setChange() ๋ฉ์๋๋ ์ต์ ๋ฒ๋ค์ ์ํ๋ฅผ true๋ก ๋ฐ๊ฟ์ฃผ๋ ์ญํ ์ ํ๋ค. __์ ์ด๋ฐ ๋ฉ์๋๊ฐ ํ์ํ ๊น?__  
๋ง์ฝ ํด๋น ํ๋๊ทธ ์์ด ์ต์ ๋ฒ ํจํด์ด ๊ฐ์ฉ๋๋ค๋ฉด, ์์๋ก ๋ณํํ๋ ๊ฐ์ ์์๋ก ์ ๋ฌํ๊ฒ๋๋ค. ๊ทธ๋ ๋ค๋ฉด ์์๊ฐ ๋งค์ฐ ํฌ๊ฒ ๋์ด๋  ์ ์๋ค.
์ด๋ฌํ ์ํฉ์ ๋ง๊ธฐ ์ํด์ ํน์  ์กฐ๊ฑด์ ๋ง๋๋ ๊ฒ์ด๋ค.

## ๋จ์ ?
### 1. ์์
Observable์ __ํด๋์ค__ ๋ค. ์ฆ Observable ์ฌ์ฉํ๊ธฐ ์ํด์๋ ์์์ ์ฌ์ฉํด์ผํ๋๋ฐ, '์์' ์ด๋ผ๋ ํ๋ ์์ฒด๊ฐ ๊ฐ์ฒด์งํฅ์์๋ ๋จ์ ์ผ๋ก ์์ฉํ  ์ ์๋ค.  
๊ทธ๋ฆฌ๊ณ  Observable์ ์ฌ์ฉํ๊ธฐ ์ํด์๋ ์ฌ์ฉํ๋ ค๋ ํด๋์ค๊ฐ ์๋ฌด๊ฒ๋ ์์๋ฐ์ง ์์์ผ ํ๋ค. ์ด๋ฌํ ์ด์ ๋ก ์ฌ์ฉ์ ์ ์ฝ์ ๋ฐ๊ฒ ๋๋ค.
### 2. ๋ฉ์๋ ๋ณดํธ
๋ฐ์ดํฐ๋ฅผ ์ ๋ฌํ๋๋ฐ ๊ด์ฌํ๋ ๋ฉ์๋๊ฐ protected ๋ก ๋์ด์๋ค. ์ฆ, ์์๋ฐ์ง ๋ชปํ๋ฉด ์ฌ์ฉํ์ง ๋ชปํ๋ค. ๋ฐ๋ก ์์์ ์์์ ์ ์ฝ์ด ์๋ค๊ณ  ํ์ผ๋ฏ๋ก ๋จ์  ์ค ํ๋์ด๋ค.

## โ ๋ง๋ฌด๋ฆฌ
์ต์ ๋ฒ ํจํด์ ๊ฒ์ผ๋ก ๋ณผ ๋๋ ๊ฐ ์ฃผ์  ๊ฐ์ฒด๊ฐ ์์ฐํ ๋ฐ์ดํฐ๋ฅผ ๊ฐ ์ต์ ๋ฒ ๊ฐ์ฒด์ ์ ๋ฌํ์ฌ ์๋์ผ๋ก ์ต์ ๋ฒ ๊ฐ์ฒด๋ง ์ด์ฉํ์ฌ ํ์ ํ  ์ ์๊ฒํ๋ ํจํด์ผ๋ก ๋ณด์๋ค.  
์ต์ ๋ฒ ํจํด์ ๋ด๋ถ์์ ๊ฐ ๋ฐ์ดํฐ๋ฅผ ์ ๋ฌํ๊ธฐ ์ํด์๋ ์ฃผ์  ๊ฐ์ฒด, ์ต์ ๋ฒ ๊ฐ์ฒด์ ๊ฐ ๋ฉ์๋๋ฅผ ์๋ก ์ด์ฉํ์ฌ ๋ฐ์ดํฐ๋ฅผ ์ ๋ฌํ๊ณ , ์ต์ ๋ฒ๋ฅผ ๊ด๋ฆฌํ๋ ๊ฒ ์ฒ๋ผ ๋ณด์ธ๋ค.

