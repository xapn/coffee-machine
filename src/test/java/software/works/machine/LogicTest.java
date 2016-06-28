package software.works.machine;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

public class LogicTest {

    private Logic sut;
    private DrinkMaker drinkMakerMock;

    @Before
    public void prepareFixtures() {
        drinkMakerMock = mock(DrinkMaker.class);
        sut = new Logic(drinkMakerMock);
    }

    @Test
    public void should_make_tea() {
        // GIVEN
        CustomerOrder customerOrder = new CustomerOrder(Drink.TEA);
        drinkMakerMock.makeDrink(new Message("T::"));
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(customerOrder);

        // THEN
        verify(drinkMakerMock);
    }

    @Test
    public void should_make_chocolate() {
        // GIVEN
        CustomerOrder customerOrder = new CustomerOrder(Drink.CHOCOLATE);
        drinkMakerMock.makeDrink(new Message("H::"));
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(customerOrder);

        // THEN
        verify(drinkMakerMock);
    }
}