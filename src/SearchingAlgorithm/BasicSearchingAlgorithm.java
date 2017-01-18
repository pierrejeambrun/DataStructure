package SearchingAlgorithm;

import java.util.*;

public class BasicSearchingAlgorithm {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(linearSearch(myArray,3));
    }

    public static int linearSearch(int[] myData, int valueToFind) {
        for (int i = 0; i < myData.length; i++) {
            if (myData[i] == valueToFind) {
                return i;
            }
        }
        return -1;
    }

    public static boolean selfOrganisationSearch(int[] myData, int valueToFind) {
        for (int i = 0; i < myData.length; i++) {
            if (myData[i] == valueToFind) {
                if (i == 0)
                    return true;
                int temp = myData[i];
                myData[i] = myData[i - 1];
                myData[i - 1] = temp;
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] myData, int valueToFind, int firstIndex, int lastIndex) {
        int middle = (lastIndex - firstIndex) / 2;
        boolean found = false;
        if (myData[middle] == valueToFind) {
            return true;
        }
        while (myData[middle] != valueToFind && lastIndex - firstIndex >= 1) {
            if (valueToFind < myData[middle]) {
                int[] copyOfRange = Arrays.copyOfRange(myData, firstIndex, middle);
               return binarySearchRecursive(copyOfRange, valueToFind, firstIndex, middle);
            }
            if (valueToFind > myData[middle]) {
                int[] copyOfRange = Arrays.copyOfRange(myData, middle + 1, lastIndex+1);
                lastIndex = copyOfRange.length - 1;
                return binarySearchRecursive(copyOfRange, valueToFind, 0, lastIndex);
            }
        }
        return false;
    }

    public static boolean simpleBinarySearch(int[] myData, int valueToFind, int firstIndex, int lastIndex) {
       while(lastIndex >= firstIndex){
           int mid = (lastIndex - firstIndex)/2 + firstIndex;
           if(valueToFind < myData[mid]){
               lastIndex = mid - 1;
           }
           if(valueToFind > myData[mid]){
               firstIndex = mid + 1;
           } else return true;
       }
        return false;
    }
}
