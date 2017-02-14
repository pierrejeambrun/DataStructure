package CodeInterview;

import java.util.Arrays;

public class SearchingAndSorting {
    //    a need to have a buffer long enough at the end of the array.
    public void mergeSortedArrays(int[] a, int[] b, int endofa) {
        int aCursor = a.length - 1;
        int bCursor = b.length - 1;
        while (endofa != -1 && bCursor != -1) {
            if (a[endofa] < b[bCursor]) {
                a[aCursor--] = b[bCursor--];
            } else {
                a[aCursor--] = a[endofa--];
            }
        }

    }

    public void sortArrayOfString(String[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            char[] myString = myArray[i].toCharArray();
            Arrays.sort(myString);
            myArray[i] = String.valueOf(myString);
        }
        Arrays.sort(myArray);
    }

    public int searchWithEmpty(String[] myArray, int start, int end, String search) {
        int middle = (start + end) / 2;
        if (start > end)
            return -1;
        while (middle < end - 1 && myArray[middle].equals("")) {
            middle++;
        }
        if (myArray[middle].equals("")) {
            while (middle > start && myArray[middle].equals("")) {
                middle--;
            }
        }
        if (search.equals(myArray[middle]))
            return middle;
        else {
            if (search.compareTo(myArray[middle]) < 0)
                middle = searchWithEmpty(myArray, start, middle - 1, search);
            if (search.compareTo(myArray[middle]) > 0)
                middle = searchWithEmpty(myArray, middle + 1, end, search);
        }
        return middle; //Think to replicate the return statement.
    }
}
