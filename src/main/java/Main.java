import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonina on 2018-10-11.
 */
public class Main {
    public static void main(String[] args) throws NotPossibleToGiveChangeException, NotSuchBeverageException, NotEnoughAmountOfMoneyException, NotEnoughMilkException, NotEnoughSpaceForCoinsException, NotEnoughCupsException {
        Machine tchibo = new Machine();
        List<Coin> money = new ArrayList<>();
        money.add(Coin.ZL2);
        tchibo.orderCoffee(CoffeeType.BLACK_COFFEE, money);
        System.out.println(tchibo.getCoffeeDistributor().getAmountOfCups());
        tchibo.getMachineCoins().showMoney();
        System.out.println();
        tchibo.orderCoffee(CoffeeType.WHITE_COFFEE_WITH_SUGAR, money);
        tchibo.getMachineCoins().showMoney();
        System.out.println();
        System.out.println(tchibo.getCoffeeDistributor().getAmountOfCups());
        System.out.println(tchibo.getCoffeeDistributor().getAmountOfMilk());
    }
}
