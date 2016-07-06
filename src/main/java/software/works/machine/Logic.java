package software.works.machine;

public class Logic {

    private DrinkMaker drinkMaker;
    private DrinkRepository drinkRepository;

    private Logic() {
        drinkRepository = new DrinkRepository();
    }

    public Logic(DrinkMaker drinkMaker) {
        this();
        this.drinkMaker = drinkMaker;
    }

    public void sendOrderToDrinkMaker(CustomerOrder customerOrder) {
        if (customerHasNotPaid(customerOrder)) {
            drinkMaker.makeDrink(new Message("M:It lacks some money."));
        } else {
            StringBuilder instructions = new StringBuilder();

            instructions.append(drinkInstruction(customerOrder)) //
                    .append(sugarInstruction(customerOrder)) //
                    .append(stickInstruction(customerOrder));

            drinkMaker.makeDrink(new Message(instructions.toString()));
        }
    }

    private boolean customerHasNotPaid(CustomerOrder customerOrder) {
        return customerOrder.getAmountOfMoney() < drinkRepository.findAll().get(customerOrder.getDrink()).getPrice();
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