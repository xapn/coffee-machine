package software.works.machine;

public class CustomerOrder {

    private Drink drink;

    public CustomerOrder(Drink drink) {
        this.drink = drink;
    }

    public CustomerOrder(Drink drink, int numberOfSugars) {
        throw new RuntimeException("Not yet implemented!");
    }

    public Drink getDrink() {
        return drink;
    }
}