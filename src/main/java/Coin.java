/**
 * Created by Antonina on 2018-10-11.
 */
public enum Coin {
    ZL5(5), ZL2(2), ZL1(1), GR50(0.5), GR10(0.1), GR5(0.05);

    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    private double value;
}
