package model;

import java.util.ArrayList;

public class Store {
    private String storeId;
    private String storeName;
    private String location;
    private ArrayList<StockRecord> stockRecords;

    public Store(String storeId, String storeName, String location){
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.stockRecords = new ArrayList<>();
    }

    public String getStoreId(){
        return storeId;
    }

    public String getStoreName(){
        return storeName;
    }

    public String getLocation(){
        return location;
    }

    public void addStoreRecord(StockRecord stockRecord){
        stockRecords.add(stockRecord);
    }
    public ArrayList<StockRecord> getStockRecords(){
        return stockRecords;
    }
}
