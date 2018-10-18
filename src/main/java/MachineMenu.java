import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antonina on 2018-10-15.
 */
public class MachineMenu {
    private static Map<CoffeeType, CoffeeDetails> coffeeMenu = new HashMap<>();
    private static MachineMenu machineMenu;

    private MachineMenu(){
        this.coffeeMenu = initCoffeeMenu();
    }

    public static MachineMenu getInstance(){
        if(machineMenu==null){
            machineMenu = new MachineMenu();
        }
        return machineMenu;
    }

    //określenie cen i zużycia mleka dla poszczególnych typów kaw
    private static Map<CoffeeType, CoffeeDetails> initCoffeeMenu() {
        coffeeMenu.put(CoffeeType.WHITE_COFFEE, new CoffeeDetails(1.80, 0.5));
        coffeeMenu.put(CoffeeType.BLACK_COFFEE, new CoffeeDetails(1.60, 0.0));
        coffeeMenu.put(CoffeeType.WHITE_COFFEE_WITH_SUGAR, new CoffeeDetails(1.80, 0.3));
        coffeeMenu.put(CoffeeType.BLACK_COFFEE_WITH_SUGAR, new CoffeeDetails(1.60, 0.0));
        return coffeeMenu;
    }

    public static void checkBeverageExistance(CoffeeType beverage) throws NotSuchBeverageException{
        if(!hasSuchBeverage(beverage)){
            throw new NotSuchBeverageException();
        }
    }

    private static boolean hasSuchBeverage(CoffeeType beverage){
        return coffeeMenu.containsKey(beverage);
    }

    public static CoffeeDetails getBeverageDetails(CoffeeType beverage) throws NotSuchBeverageException {
        checkBeverageExistance(beverage);
        return coffeeMenu.get(beverage);
    }
}
