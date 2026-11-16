package algorithms;

import data.DataManager;
import java.util.ArrayList;
import model.DistributionCentre;
import model.ReplenishmentRequest;
import model.StockRecord;
import model.Store;


public class AllocationEngine {
    private DataManager dataManager;

    public AllocationEngine(DataManager dataManager){
        this.dataManager =  dataManager;
    }

    public void sortRequestsByPriority(){
        ArrayList<ReplenishmentRequest> requests = dataManager.getReplenishmentRequests();

        for(int i = 0; i<requests.size(); i++){
            int highestPriorityIndex = i;

            for(int j = i +1; j< requests.size(); j++){
                if(requests.get(j).getPriority() > requests.get(highestPriorityIndex).getPriority()){
                    highestPriorityIndex = j;
                }
            }
            ReplenishmentRequest temp = requests.get(i);
            requests.set(i, requests.get(highestPriorityIndex));
            requests.set(highestPriorityIndex, temp);
        }

    }

    public StockRecord  findStoreStock(Store store, String productCode){

        for(StockRecord record : store.getStockRecords()){
            if(record.getProduct().getProductCode().equals(productCode)){
                return record;
            }
        }
        return null;
    }

    public StockRecord findCentreStock(DistributionCentre centre, String productCode){

        for(StockRecord record : centre.getStockRecords()){
            if(record.getProduct().getProductCode().equals(productCode)){
                return record;
            }
        }
        return null;
    }

    public int allocateRequest(ReplenishmentRequest request) {
        Store store = request.getStore();

        StockRecord storeRecord = findStoreStock(store, request.getProduct().getProductCode());

        if (storeRecord == null) {
            return 0;
        }

        int quantityNeeded = request.getQuantityRequired() - request.getQuantityAllocated();
            if(quantityNeeded <= 0){
                return 0;
            }

        int availableStock = 0;

        for (DistributionCentre centre : dataManager. getDistributionCentrs()) {
            StockRecord centreStock = findCentreStock(centre, request.getProduct().getProductCode());

            if (centreStock != null) {
                availableStock += centreStock.getCurrentStock();
            }
        }

        int quantityToAllocate = Math.min(quantityNeeded, availableStock);
        int remainingToAllocate = quantityToAllocate;
        int totalAllocated = 0;

        for (DistributionCentre centre : dataManager.getDistributionCentrs()) {
            StockRecord centreStock = findCentreStock(centre, request.getProduct().getProductCode());

            if (centreStock != null && remainingToAllocate > 0) {
                int amountFromCentre = Math.min(centreStock.getCurrentStock(), remainingToAllocate);
                centreStock.setCurrentStock(centreStock.getCurrentStock() - amountFromCentre);
                totalAllocated += amountFromCentre;
                remainingToAllocate -= amountFromCentre;
        }
    }

        storeRecord.setCurrentStock(storeRecord.getCurrentStock() + totalAllocated);
        request.addAllocatedQuantity(totalAllocated);
        return totalAllocated;
    }

    public void processAllRequests(){

        sortRequestsByPriority();
        for(ReplenishmentRequest request : dataManager.getReplenishmentRequests()){
            allocateRequest(request);
        }
    }


}
