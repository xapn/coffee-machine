package software.works.machine;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static software.works.machine.Drink.CHOCOLATE;
import static software.works.machine.Drink.COFFEE;
import static software.works.machine.Drink.TEA;

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

        TestProperties(CustomerOrder givenCustomerOrder, String expectedInstructions) {
            this.givenCustomerOrder = givenCustomerOrder;
            this.expectedMessage = new Message(expectedInstructions);
        }

        @Override
        public String toString() {
            return givenCustomerOrder.getDrink() + " paid with " + givenCustomerOrder.getAmountOfMoney() + " €";
        }
    }

    @Parameter
    public TestProperties properties;

    @Parameters(name = "{0}")
    public static Collection<TestProperties> dataSet() {
        return Arrays.asList( //
                new TestProperties(new CustomerOrder(TEA, 0f), "M:It lacks 0.4 €."),
                new TestProperties(new CustomerOrder(CHOCOLATE, 0.2f), "M:It lacks 0.3 €."),
                new TestProperties(new CustomerOrder(COFFEE, 0.3f), "M:It lacks 0.3 €."));
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