import java.util.ArrayList;

public class PriceList {
    private class Model {
        private String name;
        private Integer code;
        private Integer roubles;
        private Integer kopecks;
    }

    private ArrayList<Model> list = new ArrayList<>();

    public void addGood(String name, Integer code, Integer roubles, Integer kopecks) {
        Model newModel = new Model();
        newModel.name = name;
        newModel.code = code;
        newModel.roubles = roubles;
        newModel.kopecks = kopecks;
    }

    public void reprice(String name, Integer newRoubles, Integer newKopecks) {
        for (Model current : list) {
            if (current.name.equals(name)) {
                current.roubles = newRoubles;
                current.kopecks = newKopecks;
            }
        }
    }

    public void rename(Integer code, String newName) {
        for (Model current : list) {
            if (current.code.equals(code)) {
                current.name = newName;
            }
        }
    }

    public void deleteGood(String name) {
        for (Model current : list) {
            if (current.name.equals(name)) {
                list.remove(current);
            }
        }
    }

    public ArrayList<Integer> purchasePrice(Integer code, Integer amount) {
        ArrayList<Integer> purchase = new ArrayList<>();
        for (Model current : list) {
            if (current.code.equals(code)) {
                int price = (current.roubles * 100 + current.kopecks) * amount;
                int roubles = (price / 100);
                int kopecks = (price % 100);
                purchase.add(roubles);
                purchase.add(kopecks);
            }
        }
        return purchase;
    }
}
