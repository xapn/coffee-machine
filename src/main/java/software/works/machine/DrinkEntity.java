package software.works.machine;

import java.math.BigDecimal;

public class DrinkEntity {

    private Drink drink;
    private char symbol;
    private BigDecimal price;

    public DrinkEntity(Drink drink, char symbol, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }
}