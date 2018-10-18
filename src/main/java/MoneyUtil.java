import java.util.List;

/**
 * Created by Antonina on 2018-10-15.
 */
public class MoneyUtil {

    public static boolean receivedEnoughMoney(List<Coin> receivedMoney, double price){
        return price<=sumCoinsValue(receivedMoney);
    }

    public static double calculateChange(List<Coin> receivedMoney, double price){
        double change = ((sumCoinsValue(receivedMoney)*10)-(price*10))/10;
        return change;
    }

    public static double sumCoinsValue(List<Coin> receivedMoney){
        double sumOfReceivedMoney = 0.0;
        for(Coin coin : receivedMoney){
            sumOfReceivedMoney += coin.getValue();
        }
        return sumOfReceivedMoney;
    }
}
