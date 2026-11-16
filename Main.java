
import data.DataManager;
import model.Product;
import model.StockRecord;
import model.Store;
import service.InventoryManager;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    DataManager dm =  new DataManager();


    Product Milk = new Product("PR001", "Milk", "Dairy");
    Product Bread = new Product("PR002", "Bread", "Bakery");

    Store store1 = new Store("S001", "store1", "London");
    Store store2 = new Store("S001", "store2", "Croydon");


    store1.addStoreRecord(new StockRecord(Milk, "London", 5,10));
    store1.addStoreRecord(new StockRecord(Bread, "London", 20,10));
    store2.addStoreRecord(new StockRecord(Milk, "Croydon", 10, 15));

    dm.addStore(store1);
    dm.addStore(store2);

    InventoryManager manager = new InventoryManager(dm);

    for(StockRecord record : manager.getLowStockRecords()){
        System.out.println(record .getProduct().getProductName());
        }

    System.out.println(manager.getTotalStock("PR001"));
    }

    
}
