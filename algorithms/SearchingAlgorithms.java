package algorithms;

import model.Product;
import java.util.ArrayList;

public class SearchingAlgorithms {
    
    public int linearSearch(ArrayList<Product> products, String productCode){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductCode().equals(productCode)){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(ArrayList<Product> products, String productCode) {
    int left = 0;
    int right = products.size() - 1;

    while (left <= right) {
        int middle = (left + right) / 2;
        String middleCode = products.get(middle).getProductCode();

        if (middleCode.equals(productCode)) {
            return middle;
        }
        else if (middleCode.compareTo(productCode) < 0) {
            left = middle + 1;
        }
        else{
            right = middle - 1;
        } 
    }

    return -1;
    }



}

