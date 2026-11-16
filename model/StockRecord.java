package model;

public class StockRecord {
    private Product product;
    private String locationName;
    private int currentStock;
    private int minimumStockThreshold;

    public StockRecord(Product product, String locationName, int currentStock, int minimumStockThreshold){
        this.product = product;
        this.locationName = locationName;
        this.currentStock = currentStock;
        this.minimumStockThreshold =  minimumStockThreshold;
    }

    public Product getProduct(){
        return product;
    }

    public String getLocationName(){
        return locationName;
    }

    public int getCurrentStock(){
        return currentStock;
    }

    public int getMinimumStockThreshold(){
        return minimumStockThreshold;
    }

    public void setMinimumStockThreshold(int minimumStockThreshold){
        this.minimumStockThreshold = minimumStockThreshold;
    }
    
    public void setCurrentStock(int currentStock){
        this.currentStock = currentStock;
    }

    public boolean needReplenishment(){
        return currentStock < minimumStockThreshold;
    }
    
    public int getUnitBelowThreshold(){
        if(needReplenishment()){
            return minimumStockThreshold - currentStock;
        }else{
            return 0;
        }
    }
}
