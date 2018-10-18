/**
 * Created by Antonina on 2018-10-11.
 */
public class CoffeeDetails {
    private double price;
    private double amountOfMilk;

    public CoffeeDetails(double price, double amountOfMilk){
        this.price = price;
        this.amountOfMilk = amountOfMilk;
    }

    public double getPrice() {
        return price;
    }

    public double getAmountOfMilk() {
        return amountOfMilk;
    }
}
