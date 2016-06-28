package software.works.machine;

public class Logic {

    private DrinkMaker drinkMaker;

    public Logic(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void sendOrderToDrinkMaker(CustomerOrder customerOrder) {
        String instructions = null;

        switch (customerOrder.getDrink()) {
        case TEA:
            instructions = "T::";
            break;
        case CHOCOLATE:
            instructions = "H::";
            break;
        case COFFEE:
            instructions = "C::";
            break;
        default:
            break;
        }

        drinkMaker.makeDrink(new Message(instructions));
    }
}