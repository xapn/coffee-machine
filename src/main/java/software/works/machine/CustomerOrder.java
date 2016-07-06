package software.works.machine;

import java.math.BigDecimal;

public class CustomerOrder {

    private Drink drink;
    private int numberOfSugars;
    private BigDecimal amountOfMoney;

    public CustomerOrder(Drink drink) {
        this.drink = drink;
    }

    public CustomerOrder(Drink drink, BigDecimal amountOfMoney) {
        this.drink = drink;
        this.amountOfMoney = amountOfMoney;
    }

    public CustomerOrder(Drink drink, int numberOfSugars, BigDecimal amountOfMoney) {
        this.drink = drink;
        this.numberOfSugars = numberOfSugars;
        this.amountOfMoney = amountOfMoney;
    }

    public CustomerOrder(Drink drink, boolean extraHot, BigDecimal amountOfMoney) {
        throw new RuntimeException("Not yet implemented!");
    }

    public Drink getDrink() {
        return drink;
    }

    public int getNumberOfSugars() {
        return numberOfSugars;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public String toString() {
        return String.format(drink + " with " + numberOfSugars + " sugars");
    }

}