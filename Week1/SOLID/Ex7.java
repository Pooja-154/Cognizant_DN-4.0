import java.util.*;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setPrice(150.75);
        System.out.println("----");
        stockMarket.setPrice(160.25);
    }
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }
}

interface Observer {
    void update(double price);
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App - New Stock Price: " + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App - New Stock Price: " + price);
    }
}
