package software.works.machine;

import java.math.BigDecimal;

public class CustomerOrder {

    private Drink drink;
    private int numberOfSugars;
    private BigDecimal amountOfMoney;
    private boolean extraHot;

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
        this.drink = drink;
        this.extraHot = extraHot;
        this.amountOfMoney = amountOfMoney;
    }

    public CustomerOrder(Drink drink, boolean extraHot, int numberOfSugars, BigDecimal amountOfMoney) {
        this.drink = drink;
        this.extraHot = extraHot;
        this.numberOfSugars = numberOfSugars;
        this.amountOfMoney = amountOfMoney;
    }

    public Drink getDrink() {
        return drink;
    }

    public boolean isExtraHot() {
        return extraHot;
    }

    public int getNumberOfSugars() {
        return numberOfSugars;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public String toString() {
        return String.format(drink + (extraHot ? " extra-hot" : "") + " with " + numberOfSugars + " sugars");
    }
}