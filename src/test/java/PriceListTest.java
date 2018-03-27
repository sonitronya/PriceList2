import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;

public class PriceListTest {
    @Test
    public void addGood(){
        PriceList priceList = new PriceList();
        assertTrue(priceList.addGood("Помидоры", 1000, 60, 90));
    }
    @Test
    public void reprice(){
        PriceList priceList = new PriceList();
        priceList.addGood("Помидоры", 1000, 60, 90);
        assertTrue(priceList.reprice(1000, 55, 40));

    }
    @Test
    public void rename(){
        PriceList priceList = new PriceList();
        priceList.addGood("Помидоры", 1000, 60, 90);
        priceList.rename(1000,"Огурцы");
        assertTrue(priceList.rename(1000,"Огурцы"));
    }
    @Test
    public void deleteGood(){
        PriceList priceList = new PriceList();
        priceList.addGood("Помидоры", 1000, 60, 90);
        assertTrue(priceList.deleteGood(1000));
    }
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