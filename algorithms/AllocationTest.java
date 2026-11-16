package algorithms;

import data.DataManager;
import java.time.LocalDateTime;

import java.time.LocalDate;

import model.Product;
import model.Store;
import model.StockRecord;
import model.DistributionCentre;
import model.ReplenishmentRequest;

public class AllocationTest {

    public static void main(String[] args) {
        DataManager dm = new DataManager();

        Product Milk = new Product("PR001", "Milk", "Dairy");
        dm.addProduct(Milk);

        Store Store1 = new Store("S001", "Mitcham Store", "Mitcham");
        dm.addStore(Store1);

        StockRecord storeMilk = new StockRecord(Milk, "Mitcham Store", 5, 10);
        Store1.addStoreRecord(storeMilk);

        DistributionCentre centre1 = new DistributionCentre("DC001", "North Distribution Centre", "North London");
        dm.addDistributionCentre(centre1);

        DistributionCentre centre2 = new DistributionCentre("DC002", "South Distribution Centre", "South London");
        dm.addDistributionCentre(centre2);

        StockRecord Centre1Milk = new StockRecord(Milk, "North Distribution Centre", 15, 0);
        StockRecord Centre2Milk = new StockRecord(Milk, "South Distribution Centre", 15, 0);
        centre1.addStockRecord(Centre1Milk);
        centre2.addStockRecord(Centre2Milk);

        ReplenishmentRequest request1 = new ReplenishmentRequest("REQ001", Store1, Milk, 20, 5, 5, LocalDateTime.now(), LocalDateTime.now().plusDays(2), 20);
        dm.addReplenishmentRequest(request1);

        AllocationEngine  engine = new AllocationEngine(dm);
        engine.processAllRequests();                                                                            //1 .low, 2, medium, 3 high, 4 urgent 5 critical

        System.out.println("store stock: " + storeMilk.getCurrentStock());
        System.out.println("centre 1 stock: " + Centre1Milk.getCurrentStock());
        System.out.println("Centre 2 stock: " + Centre2Milk.getCurrentStock());
        System.out.println("Quantity allocated: " + request1.getQuantityAllocated());

        ReplenishmentRequest request2 = new ReplenishmentRequest("REQ002", Store1, Milk, 5, 5, 2, LocalDateTime.now(), LocalDateTime.now().plusDays(3), 10);
        ReplenishmentRequest request3 = new ReplenishmentRequest("REQ003", Store1, Milk, 5, 5, 4, LocalDateTime.now(), LocalDateTime.now().plusDays(1), 15);
        dm.addReplenishmentRequest(request2);
        dm.addReplenishmentRequest(request3);

        engine.processAllRequests();
        
        for(ReplenishmentRequest request : dm.getReplenishmentRequests()){
            System.out.println(request.getRequestId() + "priority " + request.getPriority());
        }

        System.out.println("Request 1 allocated" + request1.getQuantityAllocated());
        System.out.println("Request 2 allocated" + request2.getQuantityAllocated());
        System.out.println("Request 3 allocated" + request3.getQuantityAllocated());

    }   

    
}
