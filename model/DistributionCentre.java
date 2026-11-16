package  model;

import java.util.ArrayList;

public class DistributionCentre{
    private String centreId;
    private String centreName;
    private String location;
    private ArrayList<StockRecord> stockRecords;

    public DistributionCentre(String centreId, String centreName, String location){
        this.centreId = centreId;
        this.centreName =  centreName;
        this.location =  location;
        this.stockRecords = new ArrayList<>();
    }
    
    public String getCentreId(){
        return centreId;
    }

    public String getCentreName(){
        return centreName;
    }

    public String getLocation(){
        return location;
    }

    public ArrayList<StockRecord> getStockRecords(){
        return stockRecords;
    }

    public void addStockRecord(StockRecord stockRecord){
        stockRecords.add(stockRecord);
    }

    @Override 
    public String toString(){
        return centreId + " - " + centreName;
    }

}