package Test;

import All.CodeInterviewSearchingAndSorting;
import junit.framework.TestCase;

public class TestCodeInterviewSearchingAndSorting extends TestCase {

    public void test_mergeSortedArrays() {
        int[] a = {1, 2, 3, 5, 6, 7, 0, 0, 0};
        int[] b = {1, 8, 9};
        CodeInterviewSearchingAndSorting codeInterviewSearchingAndSorting = new CodeInterviewSearchingAndSorting();
        codeInterviewSearchingAndSorting.mergeSortedArrays(a, b, 5);
        assertEquals(1, a[0]);
        assertEquals(1, a[1]);
        assertEquals(2, a[2]);
        assertEquals(3, a[3]);
        assertEquals(5, a[4]);
        assertEquals(6, a[5]);
        assertEquals(7, a[6]);
        assertEquals(8, a[7]);
        assertEquals(9, a[8]);
    }

    public void test_sortArrayOfString() {
        String[] myArray = {"toto", "tutu", "ttoo", "oott", "atata", "uutt"};
        CodeInterviewSearchingAndSorting codeInterviewSearchingAndSorting = new CodeInterviewSearchingAndSorting();
        codeInterviewSearchingAndSorting.sortArrayOfString(myArray);
        for (String s : myArray)
            System.out.println(s);
    }

    public void test_searchWithEmpty_when_word_is_present() {
        CodeInterviewSearchingAndSorting codeInterviewSearchingAndSorting = new CodeInterviewSearchingAndSorting();
        String[] myArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int ball = codeInterviewSearchingAndSorting.searchWithEmpty(myArray, 0, myArray.length - 1, "ball");
        assertEquals(4, ball);
    }

    public void test_searchWithEmpty_when_word_is_not_present() {
        CodeInterviewSearchingAndSorting codeInterviewSearchingAndSorting = new CodeInterviewSearchingAndSorting();
        String[] myArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int result = codeInterviewSearchingAndSorting.searchWithEmpty(myArray, 0, myArray.length - 1, "tutu");
        assertEquals(-1, result);
    }

}