package software.works.machine;

import static software.works.machine.Drink.CHOCOLATE;
import static software.works.machine.Drink.COFFEE;
import static software.works.machine.Drink.TEA;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DrinkRepository {

    private Map<Drink, DrinkEntity> drinks;

    @SuppressWarnings("serial")
    public DrinkRepository() {
        drinks = new HashMap<Drink, DrinkEntity>() {
            {
                this.put(Drink.TEA, new DrinkEntity(TEA, 'T', new BigDecimal("0.4")));
                this.put(Drink.CHOCOLATE, new DrinkEntity(CHOCOLATE, 'H', new BigDecimal("0.5")));
                this.put(Drink.COFFEE, new DrinkEntity(COFFEE, 'C', new BigDecimal("0.6")));
            }
        };
    }

    public Map<Drink, DrinkEntity> findAll() {
        return drinks;
    }
}