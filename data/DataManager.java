package data;

import java.util.ArrayList;
import model.DistributionCentre;
import model.Product;
import model.ReplenishmentRequest;
import model.SalesRecord;
import model.Store;

public class DataManager {
    private ArrayList<Product> products;
    private ArrayList<Store> stores;
    private ArrayList<DistributionCentre> distributionCentres;
    private ArrayList<ReplenishmentRequest> replenishmentRequests;
    private ArrayList<SalesRecord> salesRecords;

    public DataManager(){
        this.products = new ArrayList<>();
        this.stores =  new ArrayList<>();
        this.distributionCentres =  new ArrayList<>();
        this.replenishmentRequests =  new ArrayList<>();
        this.salesRecords = new ArrayList<>();
    }

    public void addProduct(Product  product){
        products.add(product);
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addDistributionCentre(DistributionCentre centre){
        distributionCentres.add(centre);
    }

    public void addReplenishmentRequest(ReplenishmentRequest request){
        replenishmentRequests.add(request);
    }

    public void addSalesRecord(SalesRecord salesRecord){
        salesRecords.add(salesRecord);
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public ArrayList<Store> getStores(){
        return stores;
    }

    public ArrayList<DistributionCentre> getDistributionCentrs(){
        return distributionCentres;
    }

    public ArrayList<ReplenishmentRequest> getReplenishmentRequests(){
        return replenishmentRequests;
    }

    public ArrayList<SalesRecord> getSalesRecords(){
        return salesRecords;
    }
}
