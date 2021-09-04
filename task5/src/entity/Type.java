package entity;

public abstract class Type {
    private String name;

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }
}
