package software.works.machine;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

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

    private static class TestProperties {
        private CustomerOrder givenCustomerOrder;
        private Message expectedMessage;

        public TestProperties(Drink givenDrink, String expectedMessage) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink);
            this.expectedMessage = new Message(expectedMessage);
        }

        public TestProperties(Drink givenDrink, int givenNumberOfSugars, String expectedMessage) {
            this.givenCustomerOrder = new CustomerOrder(givenDrink, givenNumberOfSugars);
            this.expectedMessage = new Message(expectedMessage);
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
        return Arrays.asList(new TestProperties(Drink.TEA, "T::"), //
                new TestProperties(Drink.CHOCOLATE, "H::"), //
                new TestProperties(Drink.COFFEE, "C::"), //
                new TestProperties(Drink.TEA, 1, "T:1:0") //
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