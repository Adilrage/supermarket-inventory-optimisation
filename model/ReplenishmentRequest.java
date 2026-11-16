package model;

import java.time.LocalDateTime;

public class ReplenishmentRequest {
    private String requestId;
    private Store store;
    private Product product;
    private int quantityRequired;
    private int currentStock;
    private int priority;
    private LocalDateTime requestDate;
    private LocalDateTime deliveryDeadline;
    private int expectedDemand;
    private int quantityAllocated =0;
    

    public ReplenishmentRequest(
        String requestId,
        Store store,
        Product product,
        int quantityRequired,
        int currentStock,
        int priority,
        LocalDateTime requestDate,
        LocalDateTime deliveryDeadline,
        int expectedDemand
    ){
        this.requestId = requestId;
        this.store = store;
        this.product =  product;
        this.quantityRequired= quantityRequired;
        this.currentStock= currentStock;
        this.priority = priority;
        this.requestDate =  requestDate;
        this.deliveryDeadline = deliveryDeadline;
        this.expectedDemand =expectedDemand;
    }

    public String getRequestId(){
        return requestId;
    }

    public Store getStore(){
        return store;
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantityRequired(){
        return quantityRequired;
    }

    public int getCurrentStock(){
        return currentStock;
    }

    public int getPriority(){
        return priority;
    }

    public LocalDateTime getRequestDate(){
        return requestDate;
    }
    public LocalDateTime getDeliveryDeadline(){
        return deliveryDeadline;
    }

    public int getExpectedDemand(){
        return expectedDemand;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public void setCurrentStock(int currentStock){
        this.currentStock =  currentStock;
    }

    public boolean isOverDue(){
        return LocalDateTime.now().isAfter(deliveryDeadline);
    }

    public int getQuantityAllocated(){
        return quantityAllocated;
    }
    
    public void addAllocatedQuantity(int quantity){
        quantityAllocated += quantity;
    }

    @Override 
    public String toString(){
        return requestId + " - " + requestDate;
    }
}
