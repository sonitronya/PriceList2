import java.util.ArrayList;

public final class PriceList {
    private class Model {
        private String name;
        private Integer code;
        private Integer roubles;
        private Integer kopecks;
    }

    private ArrayList<Model> list = new ArrayList<>();
    private ArrayList<Integer> codes = new ArrayList<>();

    public boolean hasGood(Integer code) {
        return codes.contains(code);
    }

    public boolean addGood(String name, Integer code, Integer roubles, Integer kopecks) {
        if (!hasGood(code)) {
            Model nModel = new Model();
            nModel.name = name;
            nModel.code = code;
            nModel.roubles = roubles;
            nModel.kopecks = kopecks;
            list.add(nModel);
            codes.add(code);
            return true;
        } else throw new IllegalArgumentException("Товар уже записан");
    }

    public boolean reprice(Integer code, Integer newRoubles, Integer newKopecks) {
        if (hasGood(code)) {
            for (Model current : list) {
                if (current.code.equals(code)) {
                    current.roubles = newRoubles;
                    current.kopecks = newKopecks;
                    break;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Такого товара нет в списке");
        }
    }

    public boolean rename(Integer code, String newName) {
        if (hasGood(code)) {
            for (Model current : list) {
                if (current.code.equals(code)) {
                    current.name = newName;
                    break;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Такого товара нет в списке");
        }
    }

    public boolean deleteGood(Integer code) {
        if (hasGood(code)) {
            for (Model current : list) {
                if (current.code.equals(code)) {
                    list.remove(current);
                    break;
                }
            }
            return true;
        } else throw new IllegalArgumentException("Такого товара нет в списке");
    }

    public ArrayList<Integer> purchasePrice(Integer code, Integer amount) {
        if (hasGood(code)) {
            ArrayList<Integer> purchase = new ArrayList<>();
            for (Model current : list) {
                if (current.code.equals(code)) {
                    int price = (current.roubles * 100 + current.kopecks) * amount;
                    int nRoubles = (price / 100);
                    int nKopecks = (price % 100);
                    purchase.add(0, nRoubles);
                    purchase.add(1, nKopecks);
                }
            }
            return purchase;
        } else throw new IllegalArgumentException("Такого товара нет в спике");
    }
}
