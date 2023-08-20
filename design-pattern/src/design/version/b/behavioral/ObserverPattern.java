package design.version.b.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

  // Subject (Observable)
  interface StockMarket {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void setStockPrice(double price);
  }

  // Concrete Subject
  class ConcreteStockMarket implements StockMarket {

    // 상태 변화 알림을 받은 객체목록
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    // 상태 변화 알림을 받을 객체 등록
    @Override
    public void addObserver(Observer observer) {
      observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
      observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
      for (Observer observer : observers) {
        observer.update(stockPrice);
      }
    }

    // 객체 상태의 변화가 일어나면 다른 객체들에 자동으로 알림을 전달
    @Override
    public void setStockPrice(double price) {
      stockPrice = price;
      notifyObservers();
    }
  }

  // Observer
  interface Observer {

    void update(double stockPrice);
  }

  // Concrete Observer
  class StockTrader implements Observer {

    private String name;

    public StockTrader(String name) {
      this.name = name;
    }

    @Override
    public void update(double stockPrice) {
      System.out.println(name + ": Stock price updated to " + stockPrice);
    }
  }

  public void main() {
    ConcreteStockMarket stockMarket = new ConcreteStockMarket();

    StockTrader trader1 = new StockTrader("Trader 1");
    StockTrader trader2 = new StockTrader("Trader 2");
    StockTrader trader3 = new StockTrader("Trader 3");

    stockMarket.addObserver(trader1);
    stockMarket.addObserver(trader2);
    stockMarket.addObserver(trader3);

    stockMarket.setStockPrice(150.0);
    stockMarket.setStockPrice(155.0);
  }
}
