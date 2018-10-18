import java.util.*;

/**
 * Created by Antonina on 2018-10-11.
 */
public class Machine {

    private MachineCoins machineCoins;
    private CoffeeDistributor coffeeDistributor;

    public Machine() {
        this.machineCoins = new MachineCoins();
        this.coffeeDistributor = new CoffeeDistributor();
        MachineMenu.getInstance();
    }

    public Machine(int amountOfCups, double amountOfMilk) {
        this.coffeeDistributor = new CoffeeDistributor(amountOfCups, amountOfMilk);
        this.machineCoins = new MachineCoins();
        MachineMenu.getInstance();
    }

    public MachineCoins getMachineCoins(){
        return this.machineCoins;
    }

    public CoffeeDistributor getCoffeeDistributor() {
        return coffeeDistributor;
    }

    // zamówienie kawy, wydanie reszty
    public CoffeeAndChange orderCoffee(CoffeeType choice, List<Coin> clientCoins) throws NotEnoughSpaceForCoinsException, NotSuchBeverageException, NotPossibleToGiveChangeException, NotEnoughCupsException, NotEnoughMilkException, NotEnoughAmountOfMoneyException {
        /*
        * 1. czy jest taki napoj
        * 2. czy są kubki
        * 3. czy jest mleko
        * 4. czy klient wrzucił wystarczająco pieniędzy
        * 5. czy automat nie będzie przepelniony
        * 6. czy mozna wydac resztę
        * 7. dodaj pieniądze do kasy maszyny
        * 8. wydaj napój i pieniądze
        * */

        double price = MachineMenu.getBeverageDetails(choice).getPrice();
        double change = MoneyUtil.calculateChange(clientCoins, price);

        MachineMenu.checkBeverageExistance(choice);
       // coffeeDistributor.checkAmountOfCups();
       // coffeeDistributor.checkAmountOfMilk(amountOfMilkForBeverage);
       // machineCoins.checkAmountOfMoney(clientCoins, price);
       // machineCoins.checkSpaceForCoins(clientCoins);
       // machineCoins.checkPossibilityOfGivingChange(change);
        machineCoins.insertCoins(clientCoins);
        CoffeeType coffeeForClient = coffeeDistributor.giveBeverage(choice);
        List<Coin> changeForClient = machineCoins.giveChange(clientCoins, change);
        return CoffeeAndChange.accomplishOrder(changeForClient, coffeeForClient);
    }
}
