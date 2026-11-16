package ui;

import algorithms.AllocationEngine;
import data.DataManager;
import java.util.Scanner;
import model.DistributionCentre;
import model.Product;
import model.ReplenishmentRequest;
import model.StockRecord;
import model.Store;
import service.InventoryManager;


public class MainMenu {
    private Scanner scanner = new Scanner(System.in);
    private DataManager dataManager;
    private InventoryManager inventoryManager;
    private AllocationEngine allocationEngine;

    public MainMenu(DataManager dataManager){
        this.dataManager = dataManager;
        this.inventoryManager = new InventoryManager(dataManager);
        this.allocationEngine = new AllocationEngine(dataManager);
    }


    public void displayMenu(){

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                     SUPERMARKET INVENTORY SYSTEM           ");
        System.out.println("============================================================");

        System.out.println("Inventory Management"); 
        System.out.println("============================================================");

        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println();

        System.out.println("INVENTORY");// product and store
        System.out.println(" [1] Product Management");
        System.out.println(" [2] Store Inventory   ");
        System.out.println(" [3] Low Stock Alert   ");
        System.out.println();

        System.out.println("Distribution");//centre and replensih
        System.out.println(" [4] Distribution Centre Stock");
        System.out.println(" [5] Replenishment Requests   ");
        System.out.println(" [6] Process Stock Allocation ");
        System.out.println();

        System.out.println("Report"); //summary
        System.out.println(" [7] Inventory Summary");
        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println(" [0]  Exit System");
        System.out.println("------------------------------------------------------------");

        System.out.println("select an option");
    }

    public int getUserChoice(){
        System.out.println("Enter your choice: ");
        return scanner.nextInt();
    }

    public void start(){
        int choice;

        do{
            displayMenu();
            choice = getUserChoice();
            System.out.println();
            
            switch (choice) {
                case 1:
                    System.out.println("\n--- Product Management ---");
                    for(Product product : dataManager.getProducts()){
                        System.out.println(product);
                    }

                    break;
                case 2:
                    System.out.println("opening store inventory...");
                    for(Store store :  dataManager.getStores()){
                        System.out.println(store);
                    }

                    break; 
                case 3:
                    System.out.println("opening low stock alerts...");
                    for(StockRecord record : inventoryManager.getLowStockRecords()){
                            System.out.println(
                                record.getProduct().getProductName()
                                + "| Location: " + record.getLocationName()
                                + "| Current stock: " + record.getCurrentStock()
                                + "| Minimum stock: " + record.getMinimumStockThreshold()
                            );
                    }
                    break;
                case 4:
                    System.out.println("opening distribution centres...");
                    for(DistributionCentre centre : dataManager.getDistributionCentrs()){
                        System.out.println(centre);
                    }

                    break;
                case 5:
                    System.out.println("Opening replenishment centres");
                    for(ReplenishmentRequest request : dataManager.getReplenishmentRequests()){
                        System.out.println(request);
                    }

                    break;
                case 6:
                    System.out.println("Processing stock allocation...");

                    allocationEngine.processAllRequests();

                    System.out.println("Stock allocation completed. ");
                
                    break; 
                case 7:
                    System.out.println("Generate inventory summary...");
                    for(Product product : dataManager.getProducts()){
                        int totalStock = inventoryManager.getTotalStock(product.getProductCode());

                        System.out.println(product.getProductCode() + "| Total stock: " +  totalStock);
                    }

                    break;   
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(choice != 0);
    }

}
