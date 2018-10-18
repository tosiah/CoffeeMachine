/**
 * Created by Antonina on 2018-10-15.
 */
public class CoffeeDistributor {
    private int amountOfCups;
    private double amountOfMilk;

    public int getAmountOfCups() {
        return this.amountOfCups;
    }

    public double getAmountOfMilk() {
        return amountOfMilk;
    }

    public CoffeeDistributor(){
        this.amountOfCups = 10;
        this.amountOfMilk = 100;
    }

    public CoffeeDistributor(int amountOfCups, double amountOfMilk) {

        this.setAmountOfCups(amountOfCups);
        this.setAmountOfMilk(amountOfMilk);
    }

    public void setAmountOfCups(int amountOfCups) {
        if (amountOfCups < 0) {
            amountOfCups = 0;
        }
        this.amountOfCups = amountOfCups;
    }

    public void setAmountOfMilk(double amountOfMilk) {
        if (amountOfMilk < 0) {
            amountOfMilk = 0;
        }
        this.amountOfMilk = amountOfMilk;
    }

    //dodawanie kubków
    public void addCups(int cupsToAdd) {
        if (cupsToAdd > 0) {
            amountOfCups += cupsToAdd;
        }
        if (amountOfCups > 1000) {
            amountOfCups = 1000;
        }
    }

    //dodawanie mleka
    public void addMilk(double milkToAdd) {
        if (milkToAdd > 0) {
            amountOfMilk += milkToAdd;
        }
        if (amountOfMilk > 200) {
            amountOfMilk = 200;
        }
    }

    public CoffeeType giveBeverage(CoffeeType beverage) throws NotSuchBeverageException, NotEnoughMilkException, NotEnoughCupsException {
        double amountOfMilk = MachineMenu.getBeverageDetails(beverage).getAmountOfMilk();
        checkAmountOfMilk(amountOfMilk);
        checkAmountOfCups();
        this.amountOfMilk -= amountOfMilk;
        this.amountOfCups -= 1;
        return beverage;
    }

    private void checkAmountOfMilk(double amountOfMilk) throws NotEnoughMilkException{
        if(!isEnoughMilk(amountOfMilk)){
            throw new NotEnoughMilkException();
        }
    }

    private void checkAmountOfCups() throws NotEnoughCupsException{
        if(!isEnoughCups()){
            throw new NotEnoughCupsException();
        }
    }

    private boolean isEnoughMilk(double amountOfMilk){
        return this.amountOfMilk>=amountOfMilk;
    }

    private boolean isEnoughCups(){
        return this.amountOfCups>=1;
    }
}
