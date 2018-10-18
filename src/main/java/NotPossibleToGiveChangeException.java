/**
 * Created by Antonina on 2018-10-16.
 */
public class NotPossibleToGiveChangeException extends Exception{
    public NotPossibleToGiveChangeException(){
        super("Brak wystarczającej liczby monet poszczególnych nominałów, aby wydać resztę");
    }
}
