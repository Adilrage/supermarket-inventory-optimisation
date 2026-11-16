package model;

import java.time.LocalDate;

public class SalesRecord {
    private Store store;
    private Product product;
    private int unitSold;
    private LocalDate salesDate;

    public SalesRecord(Store store, Product product, int unitSold, LocalDate salesDate){
        this.store =  store;
        this.product = product;
        this.unitSold =  unitSold;
        this.salesDate = salesDate;
    }
    public Store getStore(){
        return store;
    }

    public Product getProduct(){
        return product;
    }

    public int getUnitSold(){
        return unitSold;
    }

    public LocalDate getSalesDate(){
        return salesDate;
    }
    
}
