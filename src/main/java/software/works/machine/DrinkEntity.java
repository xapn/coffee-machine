package software.works.machine;

public class DrinkEntity {

    private Drink drink;
    private char symbol;
    private float price;

    public DrinkEntity(Drink drink, char symbol, float price) {
        this.drink = drink;
        this.symbol = symbol;
        this.price = price;
    }

    public Drink getDrink() {
        return drink;
    }

    public char getSymbol() {
        return symbol;
    }

    public float getPrice() {
        return price;
    }
}