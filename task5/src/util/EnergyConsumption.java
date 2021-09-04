package util;
 import entity.Type;

public class EnergyConsumption extends Type {
    private int consumption;
    {
        consumption = 0;
    }

    public EnergyConsumption() {
        super("Энергопотребление");
    }

    public EnergyConsumption(String consumption) {
        super("Энергопотребление");
        this.consumption = Integer.parseInt(consumption);
    }

    @Override
    public String getValue() {
        return consumption + " ватт";
    }
}
