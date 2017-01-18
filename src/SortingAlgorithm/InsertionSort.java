package SortingAlgorithm;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Pierre on 14/01/2017.
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] myArray = {8,1,9,2,6,7,3};
        for(int i =0; i< myArray.length -1; ){
            int j = i;
            while(j > 0 && myArray[j] < myArray[j-1]){
                int temp = myArray[j];
                myArray[j] = myArray[j-1];
                myArray[j-1] = temp;
                j = j-1;
            }
            i++;
        }
        for(int i= 0 ; i<myArray.length;i++){
            System.out.println(i);
        }
    }
}
