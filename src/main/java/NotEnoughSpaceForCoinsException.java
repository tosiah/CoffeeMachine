/**
 * Created by Antonina on 2018-10-11.
 */
public class NotEnoughSpaceForCoinsException extends Exception {
    public NotEnoughSpaceForCoinsException(){
        super("Przeładowany automat. Niewystarczająco miejsca na wrzucone monety");
    }
}