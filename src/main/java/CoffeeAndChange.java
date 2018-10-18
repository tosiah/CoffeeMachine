import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonina on 2018-10-15.
 */
public class CoffeeAndChange {
    private List<Coin> change = new ArrayList<>();
    private CoffeeType beverage;

    public CoffeeAndChange(List<Coin> change, CoffeeType beverage){
        this.change = change;
        this.beverage = beverage;
    }

    public static CoffeeAndChange accomplishOrder(List<Coin> change, CoffeeType beverage){
        return new CoffeeAndChange(change, beverage);
    }
}
