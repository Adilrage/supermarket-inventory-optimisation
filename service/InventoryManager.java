package service;

import java.util.ArrayList;

import data.DataManager;
import model.Product;
import model.StockRecord;
import model.Store;

public class InventoryManager {
    private DataManager dataManager;
    

    public InventoryManager(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public Product findProduct(String productCode){

        for(Product product : dataManager.getProducts()){
            if(product.getProductCode().equals(productCode)){
                return product;
            }
        }
        return null;
    }

    public StockRecord findStockRecord(Store store, String productCode){

        for(StockRecord stockRecord: store.getStockRecords()){
            if(stockRecord.getProduct().getProductCode().equals(productCode)){
                return stockRecord;
            }
        }
        return null;
    }

    
    public ArrayList<StockRecord> getLowStockRecords(){
        ArrayList<StockRecord> lowStockRecords =  new ArrayList<> ();

        for(Store store :dataManager.getStores()){
            for(StockRecord stockRecord : store.getStockRecords()){
                if(stockRecord.needReplenishment()){
                    lowStockRecords.add(stockRecord);
                }
            }
        }
        return lowStockRecords;
    }

    public int getTotalStock(String productCode){
        int totalStock = 0;
        for(Store store : dataManager.getStores()){
            for(StockRecord stockRecord : store.getStockRecords()){
                if(stockRecord.getProduct().getProductCode().equals(productCode)){
                    totalStock += stockRecord.getCurrentStock();
                }
            }
        }

        return totalStock;
    }



}
