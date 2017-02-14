package CodeInterview;

import java.util.ArrayList;

public class StringComprehension {
    public static void main(String[] args) {
        StringComprehension stringComprehension = new StringComprehension();
        String u = "trrrioo";
        stringComprehension.revertString(u);
        stringComprehension.checkIfUniqueChar(u);
        stringComprehension.removeDuplicates(u);
        String a = "attatu";
        String b = "tttaub";
        byte[][] myImage = new byte[2][2];
        myImage[0][0] = 0001;
        myImage[0][1] = 0011;
        myImage[1][0] = 0010;
        myImage[1][1] = 0100;
        stringComprehension.areAnagrams(a, b);
        stringComprehension.replaceByPercent(" ab  c d ");
        int[][] myMatrix = new int[2][2];
        myMatrix[0][0] = 1;
        myMatrix[0][1] = 8;
        myMatrix[1][0] = 3;
        myMatrix[1][1] = 0;
        stringComprehension.putZeroOnArraysMatrix(myMatrix);
        System.out.println(stringComprehension.checkIfisRotationOf("tito", "ttio"));
    }

    public String revertString(String myStringToRevert) {
        String result = "";
        for (int i = 0; i <= myStringToRevert.length() - 1; i++) {
            result = result.concat(String.valueOf(myStringToRevert.charAt(myStringToRevert.length() - 1 - i)));
        }
        return result;
    }

    public boolean checkIfUniqueChar(String myString) {
        boolean[] contains = new boolean[256];
        for (int i = 0; i < myString.length(); i++) {
            int val = myString.charAt(i);
            if (contains[val])
                return false;
            contains[val] = true;
        }
        return true;
    }

    public String removeDuplicates(String string) {
        ArrayList<String> myArray = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (myArray.contains(String.valueOf(currentChar)))
                continue;
            myArray.add(String.valueOf(currentChar));
        }
        String result = "";
        for (String a : myArray) {
            result = result.concat(a);
        }
        return result;
    }

    public boolean areAnagrams(String string1, String string2) {
        if (string1.length() != string2.length())
            return false;
        char[] unsortedArray1 = string1.toCharArray();
        char[] unsortedArray2 = string2.toCharArray();
        quickSort(unsortedArray1, 0, string1.length() - 1);
        quickSort(unsortedArray2, 0, string2.length() - 1);
        for (int i = 0; i < unsortedArray1.length; i++) {
            if (unsortedArray1[i] != unsortedArray2[i])
                return false;
        }
        return true;
    }

    private void quickSort(char[] myArray, int start, int end) {
        if (start < end) {
            int p = findPivot(myArray, start, end);
            quickSort(myArray, start, p - 1);
            quickSort(myArray, p + 1, end);
        }
    }

    private int findPivot(char[] myArray, int start, int end) {
        int j = start;
        for (int i = j; i < end; i++) {
            if (myArray[i] <= myArray[end]) {
                char temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
                j++;
            }
        }
        char temp = myArray[end];
        myArray[end] = myArray[j];
        myArray[j] = temp;
        return j;
    }

    public String replaceByPercent(String myStringToReplace) {
        int end = myStringToReplace.length();
        for (int i = 0; i < end; i++) {
            if (myStringToReplace.charAt(i) == ' ') {
                myStringToReplace = myStringToReplace.substring(0, i).concat("%s20").concat(myStringToReplace.substring(i + 1));
                i += 3;
                end += 3;
            }
        }
        return myStringToReplace;
    }

    public byte[][] rotateImage(byte[][] myImage) {
        if (myImage == null)
            return null;

        int dimension = myImage.length - 1;
        byte[][] result = new byte[myImage.length][myImage[0].length];
        for (int i = 0; i <= dimension; i++) {
            for (int j = 0; j <= dimension; j++) {
                //row column goes to column / n - row
                result[i][j] = myImage[j][dimension - i];
            }
        }
        return result;
    }

    // A better idea would be to parse the matrix once and to keep in memory which rows and columns possess a 0, then
    // reparse the matrix and if i or j is in the rows or columns which countain at least one zero. Set [i][j] to zero.
    public int[][] putZeroOnArraysMatrix(int[][] result) {
        if (result == null)
            return null;
        int length = result.length;
        int width = result[0].length;
        int[][] matrix = new int[length][width];
        for (int i = 0; i < length; i++)
            matrix[i] = result[i].clone();
        int[] nullLengthArray = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    result[i] = nullLengthArray;
                    for (int k = 0; k < width; k++)
                        result[k][j] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public boolean checkIfisRotationOf(String string1, String string2) {
        string2 = string2.concat(string2);
        return string2.contains(string1);
    }
}
