package software.works.machine;

import java.math.BigDecimal;

public class Logic {

    private static final String INSTRUCTION_SEPARATOR = ":";
    private static final String STICK_SYMBOL = "0";
    private static final String MESSAGE_SYMBOL = "M";

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
            drinkMaker.makeDrink(new Message(MESSAGE_SYMBOL + INSTRUCTION_SEPARATOR + alertInstruction(customerOrder)));
        } else {
            StringBuilder instructions = new StringBuilder();

            instructions.append(drinkInstruction(customerOrder)) //
                    .append(sugarInstruction(customerOrder)) //
                    .append(stickInstruction(customerOrder));

            drinkMaker.makeDrink(new Message(instructions.toString()));
        }
    }

    private boolean customerHasNotPaid(CustomerOrder customerOrder) {
        return customerOrder.getAmountOfMoney()
                .subtract(drinkRepository.findAll().get(customerOrder.getDrink()).getPrice()).signum() == -1;
    }

    private String alertInstruction(CustomerOrder customerOrder) {
        BigDecimal lack = drinkRepository.findAll().get(customerOrder.getDrink()).getPrice()
                .subtract(customerOrder.getAmountOfMoney());
        return "It lacks " + lack + " €.";
    }

    private char drinkInstruction(CustomerOrder customerOrder) {
        return drinkRepository.findAll().get(customerOrder.getDrink()).getSymbol();
    }

    private String sugarInstruction(CustomerOrder customerOrder) {
        return customerWantsSugar(customerOrder) ? //
                INSTRUCTION_SEPARATOR + customerOrder.getNumberOfSugars() : INSTRUCTION_SEPARATOR;
    }

    private String stickInstruction(CustomerOrder customerOrder) {
        return customerWantsSugar(customerOrder) ? //
                INSTRUCTION_SEPARATOR + STICK_SYMBOL : INSTRUCTION_SEPARATOR;
    }

    private boolean customerWantsSugar(CustomerOrder customerOrder) {
        return customerOrder.getNumberOfSugars() > 0;
    }
}