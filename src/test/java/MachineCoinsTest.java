import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Created by Antonina on 2018-10-17.
 */
public class MachineCoinsTest {
    MachineCoins machineCoins = new MachineCoins();
    MachineCoins expectedMachineCoins = new MachineCoins();
    List<Coin> clientCoins = new ArrayList<>();
    List<Coin> coinsToFillMachineCoins = new ArrayList<>();
    List<Coin> changeCoins = new ArrayList<>();
    List<Coin> expectedChangeCoins = new ArrayList<>();
    double change;
    double expectedChange;
    double price;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        machineCoins.removeAll();
        expectedMachineCoins.removeAll();
        clientCoins = new ArrayList<>();
        coinsToFillMachineCoins = new ArrayList<>();
        changeCoins = new ArrayList<>();
        expectedChangeCoins = new ArrayList<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void giveChange_calculateChange() throws NotPossibleToGiveChangeException, NotEnoughSpaceForCoinsException, NotEnoughAmountOfMoneyException {
        coinsToFillMachineCoins = generateCoinList(5,5,5,5,5,5);
        machineCoins.insertCoins(coinsToFillMachineCoins);
        clientCoins = generateCoinList(1, Coin.ZL2);
        change = 0.2;
        changeCoins = machineCoins.giveChange(clientCoins,change);
        expectedChangeCoins = generateCoinList(2, Coin.GR10);
        assertIterableEquals(expectedChangeCoins, changeCoins);
    }

    @org.junit.jupiter.api.Test
    void giveChange_checkMachineCoins() throws NotPossibleToGiveChangeException, NotEnoughSpaceForCoinsException, NotEnoughAmountOfMoneyException {
        coinsToFillMachineCoins = generateCoinList(5,5,5,5,5,5);
        machineCoins.insertCoins(coinsToFillMachineCoins);
        clientCoins = generateCoinList(1, Coin.ZL2);
        change = 0.2;
        machineCoins.giveChange(clientCoins,change);
        expectedMachineCoins.insertCoins(generateCoinList(5,5,5,5,3,5));
        assertIterableEquals(expectedMachineCoins.getCoinsInMachine(), machineCoins.getCoinsInMachine());
    }

    @org.junit.jupiter.api.Test
    void checkAmountOfMoney_passed() throws NotEnoughAmountOfMoneyException {
        clientCoins = generateCoinList(1, Coin.ZL2);
        price = 1.6;
        machineCoins.checkAmountOfMoney(clientCoins, price);
        //assertDoesNotThrow((Executable) new NotEnoughAmountOfMoneyException());
    }

    @org.junit.jupiter.api.Test
    void checkAmountOfMoney_failed() throws NotEnoughAmountOfMoneyException {
        clientCoins = generateCoinList(1, Coin.ZL1);
        price = 1.6;
        machineCoins.checkAmountOfMoney(clientCoins, price);
    }

    @org.junit.jupiter.api.Test
    void checkSpaceForCoins() {
    }

    @org.junit.jupiter.api.Test
    void checkPossibilityOfGivingChange() {
    }

    @org.junit.jupiter.api.Test
    void canChangeBeGiven() {
    }

    @org.junit.jupiter.api.Test
    void insertCoins() {
        clientCoins = generateCoinList(3,1,3,6,7,5);
        machineCoins.insertCoins(clientCoins);
        assertIterableEquals(clientCoins, machineCoins.getCoinsInMachine());
    }

    List<Coin> generateCoinList(int amountOfCoins, Coin nominal){
        List<Coin> coins = new ArrayList<>();
        for(int i=0; i<amountOfCoins; i++){
            coins.add(nominal);
        }
        return coins;
    }

    List<Coin> generateCoinList(int amount5zl, int amount2zl, int amount1zl, int amount50gr, int amount10gr, int amount5gr){
        List<Coin> coins = new ArrayList<>();
        coins.addAll(generateCoinList(amount5zl, Coin.ZL5));
        coins.addAll(generateCoinList(amount2zl, Coin.ZL2));
        coins.addAll(generateCoinList(amount1zl, Coin.ZL1));
        coins.addAll(generateCoinList(amount50gr, Coin.GR50));
        coins.addAll(generateCoinList(amount10gr, Coin.GR10));
        coins.addAll(generateCoinList(amount5gr, Coin.GR5));
        return coins;
    }




}