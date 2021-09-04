package read;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import entity.Device;
import util.Port;
import util.EnergyConsumption;

public class InfoReader {
    public List<Device> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Device> devices = new ArrayList<>();
            Device device = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();

                        if ("device".equals(tagName)) {
                            device = new Device();
                            device.setId(reader.getAttributeValue(null, "id"));
                        } else if ("name".equals(tagName)) {
                            device.setName(reader.getElementText());
                        } else if ("critical".equals(tagName)) {
                            device.setCritical(Boolean.parseBoolean(reader.getElementText()));
                        } else if ("origin".equals(tagName)) {
                            device.setOrigin(reader.getElementText());
                        } else if ("port".equals(tagName)) {
                            Port port = new Port(reader.getElementText());
                            device.getTypes().add(port);
                        } else if ("consumption".equals(tagName)) {
                            EnergyConsumption consumption = new EnergyConsumption(reader.getElementText());
                            device.getTypes().add(consumption);
                        } else if ("price".equals(tagName)) {
                            device.setPrice(Double.parseDouble(reader.getElementText()));
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("device".equals(tagName)) {
                            devices.add(device);
                        }
                        break;
                    }
                }
            }
            return devices;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}
