package software.works.machine;

public class Logic {

    private DrinkMaker drinkMaker;

    public Logic(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void sendOrderToDrinkMaker(CustomerOrder customerOrder) {
        if (customerOrder.getDrink() == Drink.TEA) {
            drinkMaker.makeDrink(new Message("T::"));
        } else if (customerOrder.getDrink() == Drink.CHOCOLATE) {
            drinkMaker.makeDrink(new Message("H::"));
        } else {
            drinkMaker.makeDrink(new Message("C::"));
        }
    }
}