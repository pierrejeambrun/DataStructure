package SortingAlgorithm;

public class QuickSort {
    public static void main(String[] args){
        int[] myArray = {10,256,3,54,67,89,68};
        quickSort(myArray,0, myArray.length-1);
        System.out.println(myArray[0]);
        System.out.println(myArray[1]);
        System.out.println(myArray[2]);
        System.out.println(myArray[3]);
        System.out.println(myArray[4]);
        System.out.println(myArray[5]);
        System.out.println(myArray[6]);
    }

    public static void quickSort(int[] myArray, int start, int end){
        if (start < end) {
            int p = split(myArray, start, end);
            quickSort(myArray, start, p - 1);
            quickSort(myArray, p + 1, end);
        }
    }

    public static int split(int[] myArray, int start, int end){
        int p = start;
        int pivot = myArray[end];
        for(int i = start ; i < end; i++){
            if(pivot < myArray[i]){
                int transition  = myArray[i];
                myArray[i] = myArray[p];
                myArray[p] = transition;
                p++;
            }
        }
        int transition  = myArray[p];
        myArray[p] = myArray[end];
        myArray[end] = transition;
        return p;
    }
}

