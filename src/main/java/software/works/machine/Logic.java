package software.works.machine;

public class Logic {

    private DrinkMaker drinkMaker;

    public Logic(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void sendOrderToDrinkMaker(CustomerOrder customerOrder) {
        StringBuilder instructions = new StringBuilder();

        instructions.append(drinkInstruction(customerOrder)) //
                .append(sugarInstruction(customerOrder)) //
                .append(stickInstruction(customerOrder));

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
        return customerWantsSugar(customerOrder) ? ":" + customerOrder.getNumberOfSugars() : ":";
    }

    private String stickInstruction(CustomerOrder customerOrder) {
        return customerWantsSugar(customerOrder) ? ":0" : ":";
    }

    private boolean customerWantsSugar(CustomerOrder customerOrder) {
        return customerOrder.getNumberOfSugars() > 0;
    }
}