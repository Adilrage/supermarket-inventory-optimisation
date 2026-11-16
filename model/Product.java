package model;

public class Product {
    
    private String productCode;
    private String productName;
    private String category;

    public Product(String productCode, String productName, String category){
        this.productCode =  productCode;
        this.productName = productName;
        this.category = category;
    }

    public String getProductCode(){
        return productCode;
    }

    public String getProductName(){
        return productName;
    }

    public String getCategory(){
        return category;
    }

    //ran algorithm test and got the object instead of the product details

    @Override
    public String toString(){
        return productCode + " - " + productName;
    }


}
