package software.works.machine;

import java.util.HashMap;
import java.util.Map;

public class DrinkRepository {

    private Map<Drink, DrinkEntity> drinks;

    @SuppressWarnings("serial")
    public DrinkRepository() {
        drinks = new HashMap<Drink, DrinkEntity>() {
            {
                this.put(Drink.TEA, new DrinkEntity(Drink.TEA, 0.4f));
                this.put(Drink.CHOCOLATE, new DrinkEntity(Drink.CHOCOLATE, 0.5f));
                this.put(Drink.COFFEE, new DrinkEntity(Drink.COFFEE, 0.6f));
            }
        };
    }

    public Map<Drink, DrinkEntity> findAll() {
        return drinks;
    }
}