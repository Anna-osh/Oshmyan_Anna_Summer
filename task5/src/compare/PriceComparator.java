
package compare;
import entity.Device;
import java.util.Comparator;

public class PriceComparator implements java.util.Comparator<Device> {
    @Override
    public int compare(Device d1, Device d2) {
        if (d1.getPrice() < d2.getPrice()) {
            return -1;
        } else if (d1.getPrice() > d2.getPrice()) {
            return 1;
        }
        return 0;
    }
}
