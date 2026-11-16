package algorithms;

import model.Product;
import java.util.ArrayList;

public class SortingAlgorithms {
    
    public void bubbleSort(ArrayList<Product> products){ //neg comes before, post comes after
        
        for(int i = 0; i < products.size() - 1; i++){ // pass
            for(int j =0;j< products.size()- 1- i; j++){ // compar

                if(products.get(j).getProductCode().compareTo(products.get(j + 1).getProductCode() ) >0){
                    Product temp =  products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }

    }

    public void selectionSort(ArrayList<Product> products){

        for(int i = 0; i < products.size(); i++){// curr
            int smallestIndex = i;

            for(int j = i+ 1; j< products.size();j++){ // sear
                if(products.get(j).getProductCode().compareTo(products.get(smallestIndex).getProductCode())<0 ){
                    
                    smallestIndex =  j;
                }
            }
            Product temp = products.get(i);
            products.set(i, products.get(smallestIndex));
            products.set(smallestIndex, temp);
        }
    }

    public void insertionSort(ArrayList<Product> products){

        for(int i = 1; i< products.size(); i++){
            Product current =  products.get(i);

            int j = i -1;

            while(j >= 0 && products.get(j).getProductCode().compareTo(current.getProductCode()) > 0){
                products.set(j +1, products.get(j));
                j--;
            }
            products.set(j +1, current);
        }

    }
}