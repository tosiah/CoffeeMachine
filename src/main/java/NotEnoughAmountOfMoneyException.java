/**
 * Created by Antonina on 2018-10-16.
 */
public class NotEnoughAmountOfMoneyException extends Exception {
    public NotEnoughAmountOfMoneyException(){
        super("Wrzuciłeś za mało pieniędzy");
    }
}
