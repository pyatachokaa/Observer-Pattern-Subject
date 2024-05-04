import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerInvestor(Investor investor);
    void unregisterInvestor(Investor investor);
    void notifyInvestors();
}

class Stock implements Subject {
    private String symbol;
    private double price;
    private List<Investor> investors;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public void registerInvestor(Investor investor) {
        investors.add(investor);
    }

    public void unregisterInvestor(Investor investor) {
        investors.remove(investor);
    }

    public void updatePrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(this);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}

interface Observer {
    void update(Stock stock);
}

class Investor implements Observer {
    private String name;
    private List<Stock> stocks;

    public Investor(String name) {
        this.name = name;
        this.stocks = new ArrayList<>();
    }

    public void update(Stock stock) {
        System.out.println("Notified " + name + " of " + stock.getSymbol() + " price change to " + stock.getPrice());
    }

    public void investInStock(Stock stock) {
        stocks.add(stock);
        stock.registerInvestor(this);
    }

    public void divestFromStock(Stock stock) {
        stocks.remove(stock);
        stock.unregisterInvestor(this);
    }
}

class Test1 {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0);
        Stock googleStock = new Stock("GOOG", 2500.0);

        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        investor1.investInStock(appleStock);
        investor2.investInStock(appleStock);
        investor1.investInStock(googleStock);

        appleStock.updatePrice(160.0);
        googleStock.updatePrice(2600.0);
    }
}

