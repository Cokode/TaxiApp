public class LuxuryTaxi extends StandardTaxi{
    private double pricePerKilometer = 2.6;
    public LuxuryTaxi() {
        super("Johnson", "09056242738", 45, "Red", "Lexus ES350", "AJU78376", "Sedan", "Luxury ");
        this.pricePerKilometer = getPricePerKilometer();
    }
    public double getPricePerKilometer() {
        return this.pricePerKilometer;
    }
}
