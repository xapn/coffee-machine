package software.works.machine;

import static software.works.machine.Drink.CHOCOLATE;
import static software.works.machine.Drink.COFFEE;
import static software.works.machine.Drink.TEA;

import java.util.HashMap;
import java.util.Map;

public class DrinkRepository {

    private Map<Drink, DrinkEntity> drinks;

    @SuppressWarnings("serial")
    public DrinkRepository() {
        drinks = new HashMap<Drink, DrinkEntity>() {
            {
                this.put(Drink.TEA, new DrinkEntity(TEA, 'T', 0.4f));
                this.put(Drink.CHOCOLATE, new DrinkEntity(CHOCOLATE, 'H', 0.5f));
                this.put(Drink.COFFEE, new DrinkEntity(COFFEE, 'C', 0.6f));
            }
        };
    }

    public Map<Drink, DrinkEntity> findAll() {
        return drinks;
    }
}