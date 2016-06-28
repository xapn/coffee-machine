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
public class LogicTest {

    private Logic sut;
    private DrinkMaker drinkMakerMock;

    private static class TestProperties {
        private Drink givenDrink;
        private Message expectedMessage;

        public TestProperties(Drink givenDrink, String expectedMessage) {
            this.givenDrink = givenDrink;
            this.expectedMessage = new Message(expectedMessage);
        }

        @Override
        public String toString() {
            return String.format("Instructions of " + givenDrink + " should be " + expectedMessage);
        }
    }

    @Parameter
    public TestProperties properties;

    @Parameters(name = "{0}")
    public static Collection<TestProperties> dataSet() {
        return Arrays.asList(new TestProperties(Drink.TEA, "T::"), //
                new TestProperties(Drink.CHOCOLATE, "H::"), //
                new TestProperties(Drink.COFFEE, "C::") //
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
        CustomerOrder customerOrder = new CustomerOrder(properties.givenDrink);
        drinkMakerMock.makeDrink(properties.expectedMessage);
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(customerOrder);

        // THEN
        verify(drinkMakerMock);
    }
}