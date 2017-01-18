package SortingAlgorithm;

/**
 * Created by Pierre on 14/01/2017.
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] myArray = {8,1,9,2,6,7,3};
        for(int i = 0; i<myArray.length; i++){
            int mincourant = myArray[i];
            int indicecourant = i;
            for(int j = i;j<myArray.length;j++){
                if(myArray[j]<=mincourant){
                    mincourant = myArray[j];
                    indicecourant = j;
                }
            }
            int temp = myArray[i];
            myArray[i] = myArray[indicecourant];
            myArray[indicecourant] = temp;
        }

        for(int i =0; i< myArray.length;i++){
            System.out.println(myArray[i]);
        }
    }
}
