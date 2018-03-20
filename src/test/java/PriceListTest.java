import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;

public class PriceListTest {
    @Test

    public void purchasePrice() {
        PriceList priceList = new PriceList();
        priceList.addGood("Помидоры", 1000, 60, 90);
        ArrayList<Integer> price = new ArrayList<>();
        price.add(913);
        price.add(50);
        assertEquals(price,priceList.purchasePrice(1000, 15));
    }
}