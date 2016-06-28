package software.works.machine;

public class Logic {

    private DrinkMaker drinkMaker;

    public Logic(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void sendOrderToDrinkMaker(CustomerOrder customerOrder) {
        StringBuilder instructions = new StringBuilder();

        switch (customerOrder.getDrink()) {
        case TEA:
            instructions.append("T");
            break;
        case CHOCOLATE:
            instructions.append("H");
            break;
        case COFFEE:
            instructions.append("C");
            break;
        default:
            break;
        }

        instructions.append("::");

        drinkMaker.makeDrink(new Message(instructions.toString()));
    }
}