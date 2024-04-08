import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Samuel Tilley, Ciss-111-300, Program 10
//The Stock class allows for creation of Stock objects as well as retrieval of their contents.
class Stock {

    //Class Variables
    private String sSymbol;
    private Double dPrice;

    //Methods
    public Stock(String stringSymbol, Double doublePrice) {
        this.sSymbol = stringSymbol;
        this.dPrice = doublePrice;
    }

    public String getSymbol() {

        return sSymbol;
    }

    public Double getPrice() {

        return dPrice;
    }

    public void setPrice(Double newPrice) {

        dPrice = newPrice;
    }

    //Allows printing of Stock objects
    @Override public String toString() {

        return "Stock: " + this.sSymbol + "    Price: " + this.dPrice;
    }

} // End of Stock Class


//Provides methods to add stocks to a Map, and retrieve them
class Portfolio {

    //Class Variables
    private Map<String, Stock> stockHashMap = new HashMap<String, Stock>();

    //Methods
    public void setNewStock(String sSymbol, Stock stock) {

        stockHashMap.put(sSymbol, stock);
    }

    public Stock getStock(String sSymbol) {

        return stockHashMap.get(sSymbol);
    }

    public void iterateThroughStocks() {

        for (Stock i : stockHashMap.values()) {
            System.out.println( i);
        }
    }


} // End of Portfolio Class



public class Main {

    //Class Variables
    private static Random random = new Random();

    //Method for creating Random Stocks. For use only in Main.
    private static Stock createRandomStock() {

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'};

        StringBuilder stringBuilder = new StringBuilder();

        double priceTemp = random.nextDouble(43)+2;
        for (int x = 0; x < 3; x++) {
            int letterInt = random.nextInt(25);
            stringBuilder.append(alphabet[letterInt]);
        }

        Stock stock = new Stock(stringBuilder.toString().toUpperCase(),priceTemp);
        return stock;
    }

    //Main Method. Creates a random amount (20-30) stocks and then iterates through them.
    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio();

        int amountOfStocks = random.nextInt(10)+20;

        for (int i = 0; i < amountOfStocks; i++) {
            Stock stock = createRandomStock();
            portfolio.setNewStock(stock.getSymbol(),stock);

        }

        portfolio.iterateThroughStocks();


    }
} // End of Main Class