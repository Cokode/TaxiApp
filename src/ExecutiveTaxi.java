import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class ExecutiveTaxi extends StandardTaxi{
    private final double priceExecutive;
    public ExecutiveTaxi() {
        super("Frank", "07044242738", 60, "Blue", "Lexus RX350", "BUX78576", "SUV", "Executive ");
        this.priceExecutive = 5.8;
    }
    public double getPrice() {
        return this.priceExecutive;
    }
}
