package software.works.machine;

public class DrinkEntity {

    private Drink drink;
    private float price;

    public DrinkEntity(Drink drink, float price) {
        this.drink = drink;
        this.price = price;
    }

    public Drink getDrink() {
        return drink;
    }

    public float getPrice() {
        return price;
    }
}