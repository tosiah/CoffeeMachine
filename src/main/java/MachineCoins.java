import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonina on 2018-10-15.
 */
public class MachineCoins {

    private List<Coin> coinsInMachine = new ArrayList<Coin>(300);

    public List<Coin> getCoinsInMachine() {
        return coinsInMachine;
    }

    public void showMoney() {
        for (Coin coin : this.getCoinsInMachine()) {
            System.out.print(coin.getValue() + ", ");
        }
    }

    //wypełnienie Automatu monetami - po 5 monet każdego nominału
    public MachineCoins() {
        int nominalIteration = 0;
        for (Coin nominal : Coin.values()) {
            for (int i = nominalIteration; i < nominalIteration + 5; i++) {
                this.coinsInMachine.add(nominal);
            }
        }
    }

    public List<Coin> giveChange(List<Coin> receivedMoney, double change) throws NotEnoughAmountOfMoneyException, NotEnoughSpaceForCoinsException, NotPossibleToGiveChangeException {
        checkAmountOfMoney(receivedMoney, change);
        checkSpaceForCoins(receivedMoney);
        checkPossibilityOfGivingChange(change);
        List<Coin> coinsOfChange = this.findCoinsOfChange(change);
        removeCoins(coinsOfChange);
        return coinsOfChange;
    }

    public void checkAmountOfMoney(List<Coin> receivedMoney, double price) throws NotEnoughAmountOfMoneyException{
        if(!MoneyUtil.receivedEnoughMoney(receivedMoney, price)){
            throw new NotEnoughAmountOfMoneyException();
        }
    }


    public void checkSpaceForCoins(List<Coin> clientCoins)throws NotEnoughSpaceForCoinsException{
        if(!isEnoughSpace(clientCoins)){
            throw new NotEnoughSpaceForCoinsException();
        }
    }

    //spawdzenie czy jest wystarczająco miejsca w automacie na wrzucone przez klienta monety
    private boolean isEnoughSpace(List<Coin> clientCoins){
        for (Coin nominal : Coin.values()) {
            int numberOfCoins = this.countCoins(nominal, clientCoins);
            if (numberOfCoins == 0) {
                continue;
            }
            if (coinsInMachine.size() + numberOfCoins > 50) {
                if (countCoins(nominal, coinsInMachine) + numberOfCoins > 50) {
                    return false;
                }
            }
        }
        return true;
    }



    private int countCoins(Coin nominal, List<Coin> coins) {
        int amountOfCoins = 0;
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i) == nominal) {
                amountOfCoins++;
            }
        }
        return amountOfCoins;
    }

    public void checkPossibilityOfGivingChange(double change) throws NotPossibleToGiveChangeException{
        if(!canChangeBeGiven(change)){
            throw new NotPossibleToGiveChangeException();
        }
    }

    public boolean canChangeBeGiven(double change){
        return change == MoneyUtil.sumCoinsValue(this.findCoinsOfChange(change));
    }

    private List<Coin> findCoinsOfChange(double change){
        List<Coin> coinsOfChange = new ArrayList<>();
        int amountOfCoinsToReturn;
        for(Coin nominal : Coin.values()){
            if(nominal.getValue()>change){
                continue;
            }
            amountOfCoinsToReturn = this.countAmountOfCoinsToReturn(change,nominal);
            change = change - amountOfCoinsToReturn*nominal.getValue();

            for(int i=0; i<amountOfCoinsToReturn; i++){
                coinsOfChange.add(nominal);
            }
        }
        return coinsOfChange;
    }

    private int countAmountOfCoinsToReturn(double change, Coin nominal) {
        int amountOfCoinsToReturn = 0;
        int maxAmountOfCoinsToReturn = (int) (change * 10 / (nominal.getValue() * 10));
        if (maxAmountOfCoinsToReturn > 0) {
            int amountOfCoinsInMachine = countCoins(nominal, coinsInMachine);
            amountOfCoinsToReturn = Math.min(amountOfCoinsInMachine, maxAmountOfCoinsToReturn);
        }
        return amountOfCoinsToReturn;
    }



    private void removeCoins(List<Coin> coins){
        for(Coin coin : coins){
            this.coinsInMachine.remove(coin);
        }
    }


    public void insertCoins(List<Coin> coins){
        for(Coin coin : coins){
            this.coinsInMachine.add(coin);
        }
    }

    public void removeAll(){
        getCoinsInMachine().removeAll(coinsInMachine);
    }
}