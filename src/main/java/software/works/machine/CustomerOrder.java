package software.works.machine;

public class CustomerOrder {

    private Drink drink;
    private int numberOfSugars;

    public CustomerOrder(Drink drink) {
        this.drink = drink;
    }

    public CustomerOrder(Drink drink, int numberOfSugars) {
        this.drink = drink;
        this.numberOfSugars = numberOfSugars;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getNumberOfSugars() {
        return numberOfSugars;
    }

    @Override
    public String toString() {
        return String.format(drink + " with " + numberOfSugars + " sugars");
    }
}