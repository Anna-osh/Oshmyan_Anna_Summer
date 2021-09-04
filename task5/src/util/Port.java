package util;
import entity.Type;

public class Port extends Type {
    private String port;

    {
        port = null;
    }

    public Port() {
        super("Порт");
    }

    public Port(String port) {
        super("Порт");
        this.port = port;
    }

    @Override
    public String getValue() {
        return port;
    }
}
