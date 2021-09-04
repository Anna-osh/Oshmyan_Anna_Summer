package entity;

import java.util.HashSet;
import java.util.Set;


public class Device {
    private String id;
    private String name;
    private boolean critical;
    private String origin;
    private Set<Type> types;
    private double price;

    {
        id = null;
        name = null;
        critical = false;
        origin = null;
        types = new HashSet<>();
        price = 0;
    }

    public Device() {}

    public Device(String id, String name, boolean critical, String origin, Set<Type> types, double price) {
        this.id = id;
        this.name = name;
        this.critical = critical;
        this.origin = origin;
        this.types = types;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCritical(boolean critical) {   this.critical = critical;    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setTypes(Set<Type> types) {this.types = types;    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCritical() {
        return critical;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public String getOrigin() {
        return origin;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Device {" +
                "\n\tid: " + id +
                ",\n\tname: " + name +
                ",\n\tcritical: " + critical +
                ",\n\torigin: " + origin +
                ",\n\ttypes: " + types +
                ",\n\tprice: " + price +
                "\n}";
    }
}
