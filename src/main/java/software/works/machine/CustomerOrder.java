package software.works.machine;

public class CustomerOrder {

    private Drink drink;

    public CustomerOrder(Drink drink) {
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }
}