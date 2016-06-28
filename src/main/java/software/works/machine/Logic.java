package software.works.machine;

public class Logic {

    private DrinkMaker drinkMaker;

    public Logic(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void sendOrderToDrinkMaker(CustomerOrder customerOrder) {
        StringBuilder instructions = new StringBuilder();

        instructions.append(drinkInstruction(customerOrder));
        instructions.append(sugarInstruction(customerOrder));
        if (customerOrder.getNumberOfSugars() > 0) {
            instructions.append(":0");
        } else {
            instructions.append(":");
        }

        drinkMaker.makeDrink(new Message(instructions.toString()));
    }

    private String drinkInstruction(CustomerOrder customerOrder) {
        String result = null;

        switch (customerOrder.getDrink()) {
        case TEA:
            result = "T";
            break;
        case CHOCOLATE:
            result = "H";
            break;
        case COFFEE:
            result = "C";
            break;
        default:
            break;
        }

        return result;
    }

    private String sugarInstruction(CustomerOrder customerOrder) {
        return customerOrder.getNumberOfSugars() > 0 ? ":" + customerOrder.getNumberOfSugars() : ":";
    }
}