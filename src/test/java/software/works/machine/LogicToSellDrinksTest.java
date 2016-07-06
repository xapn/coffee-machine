package software.works.machine;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static software.works.machine.Drink.CHOCOLATE;
import static software.works.machine.Drink.COFFEE;
import static software.works.machine.Drink.TEA;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LogicToSellDrinksTest {

    private Logic sut;
    private DrinkMaker drinkMakerMock;

    static class TestProperties {
        CustomerOrder givenCustomerOrder;
        Message expectedMessage;

        TestProperties(Drink givenDrink, String givenAmountOfMoney, String expectedInstructions) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink, new BigDecimal(givenAmountOfMoney));
            this.expectedMessage = new Message(expectedInstructions);
        }

        @Override
        public String toString() {
            return "Instructions of " + givenCustomerOrder.getDrink() + " paid with "
                    + givenCustomerOrder.getAmountOfMoney() + " € should be " + expectedMessage;
        }
    }

    @Parameter
    public TestProperties properties;

    @Parameters(name = "{0}")
    public static Collection<TestProperties> dataSet() {
        return Arrays.asList( //
                new TestProperties(TEA, "0", "M:It lacks 0.4 €."),
                new TestProperties(CHOCOLATE, "0.3", "M:It lacks 0.2 €."),
                new TestProperties(COFFEE, "0.3", "M:It lacks 0.3 €."));
    }

    @Before
    public void prepareFixtures() {
        drinkMakerMock = mock(DrinkMaker.class);
        sut = new Logic(drinkMakerMock);
    }

    @Test
    public void should_alert_given_not_enough_money() {
        // GIVEN
        drinkMakerMock.makeDrink(properties.expectedMessage);
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(properties.givenCustomerOrder);

        // THEN
        verify(drinkMakerMock);
    }
}