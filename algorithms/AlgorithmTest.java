package algorithms;

import java.util.ArrayList;

import algorithms.SearchingAlgorithms;
import algorithms.SortingAlgorithms;
import model.Product;

public class AlgorithmTest {
    
    public static void main(String[] args){

        SortingAlgorithms sorting = new SortingAlgorithms();
        SearchingAlgorithms searching = new SearchingAlgorithms();

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("PR005", "Milk", "Dairy"));
        products.add(new Product("PR003","Bread", "Bakery"));
        products.add(new Product("PR001","Eggs", "Dairy"));
        products.add(new Product("PR004","Chicken", "Meat"));
        products.add(new Product("PR002","Rice", "Grains"));

        ArrayList<Product> bubbleProduct = new ArrayList<>(products);
        ArrayList<Product> selectionProduct = new ArrayList<>(products);
        ArrayList<Product> insertionProduct = new ArrayList<>(products);

        sorting.bubbleSort(bubbleProduct);
        System.out.println("Bubble sorting" + bubbleProduct);

        sorting.selectionSort(selectionProduct);
        System.out.println("Selection sorting " + selectionProduct);

        sorting.insertionSort(insertionProduct);
        System.out.println("insertion sorting" + insertionProduct);

        System.out.println("Linear searching:" + searching.linearSearch(products, "PR003"));
        System.out.println("Binary searching:" + searching.binarySearch(bubbleProduct, "PR003"));

        
    }
}
