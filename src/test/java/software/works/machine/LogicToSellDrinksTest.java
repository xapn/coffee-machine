package software.works.machine;

import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static software.works.machine.Drink.CHOCOLATE;
import static software.works.machine.Drink.COFFEE;
import static software.works.machine.Drink.TEA;

import org.junit.Before;
import org.junit.Test;

public class LogicToSellDrinksTest {

    private Logic sut;
    private DrinkMaker drinkMakerMock;

    @Before
    public void prepareFixtures() {
        drinkMakerMock = mock(DrinkMaker.class);
        sut = new Logic(drinkMakerMock);
    }

    @Test
    public void should_alert_given_not_enough_money_for_tea() {
        // GIVEN
        drinkMakerMock.makeDrink(new Message("M:It lacks some money."));
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(new CustomerOrder(TEA, 0f));

        // THEN
        verify(drinkMakerMock);
    }

    @Test
    public void should_alert_given_not_enough_money_for_chocolate() {
        // GIVEN
        drinkMakerMock.makeDrink(new Message("M:It lacks some money."));
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(new CustomerOrder(CHOCOLATE, 0f));

        // THEN
        verify(drinkMakerMock);
    }

    @Test
    public void should_alert_given_not_enough_money_for_coffee() {
        // GIVEN
        drinkMakerMock.makeDrink(new Message("M:It lacks some money."));
        replay(drinkMakerMock);

        // WHEN
        sut.sendOrderToDrinkMaker(new CustomerOrder(COFFEE, 0f));

        // THEN
        verify(drinkMakerMock);
    }
}