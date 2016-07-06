package software.works.machine;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static software.works.machine.Drink.CHOCOLATE;
import static software.works.machine.Drink.COFFEE;
import static software.works.machine.Drink.ORANGE_JUICE;
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
public class LogicToMakeDrinksTest {

    private Logic sut;
    private DrinkMaker drinkMakerMock;

    static class TestProperties {
        private CustomerOrder givenCustomerOrder;
        private Message expectedMessage;

        TestProperties(Drink givenDrink, String givenAmountOfMoney, String expectedInstructions) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink, new BigDecimal(givenAmountOfMoney));
            this.expectedMessage = new Message(expectedInstructions);
        }

        TestProperties(Drink givenDrink, int givenNumberOfSugars, String givenAmountOfMoney,
                String expectedInstructions) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink, givenNumberOfSugars,
                    new BigDecimal(givenAmountOfMoney));
            this.expectedMessage = new Message(expectedInstructions);
        }

        TestProperties(Drink givenDrink, boolean givenExtraHot, String givenAmountOfMoney,
                String expectedInstructions) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink, givenExtraHot, new BigDecimal(givenAmountOfMoney));
            this.expectedMessage = new Message(expectedInstructions);
        }

        public TestProperties(Drink givenDrink, boolean givenExtraHot, int givenNumberOfSugars,
                String givenAmountOfMoney, String expectedInstructions) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink, givenExtraHot, givenNumberOfSugars,
                    new BigDecimal(givenAmountOfMoney));
            this.expectedMessage = new Message(expectedInstructions);
        }

        @Override
        public String toString() {
            return String.format("Instructions of " + givenCustomerOrder + " should be " + expectedMessage);
        }
    }

    @Parameter
    public TestProperties properties;

    @Parameters(name = "{0}")
    public static Collection<TestProperties> dataSet() {
        return Arrays.asList( //
                new TestProperties(TEA, "0.4", "T::"), //
                new TestProperties(CHOCOLATE, "0.5", "H::"), //
                new TestProperties(COFFEE, "0.6", "C::"), //
                new TestProperties(ORANGE_JUICE, "0.6", "O::"), //
                new TestProperties(TEA, 1, "0.4", "T:1:0"), //
                new TestProperties(COFFEE, true, "0.6", "Ch::"), //
                new TestProperties(CHOCOLATE, true, 1, "0.5", "Hh:1:0") //
        );
    }

    @Before
    public void prepareFixtures() {
        drinkMakerMock = mock(DrinkMaker.class);
        sut = new Logic(drinkMakerMock);
    }

    @Test
    public void should_make_drink() {
        // GIVEN
        drinkMakerMock.makeDrink(properties.expectedMessage);
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(properties.givenCustomerOrder);

        // THEN
        verify(drinkMakerMock);
    }
}