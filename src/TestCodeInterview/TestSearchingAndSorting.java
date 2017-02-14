package TestCodeInterview;

import CodeInterview.SearchingAndSorting;
import junit.framework.TestCase;

public class TestSearchingAndSorting extends TestCase {

    public void test_mergeSortedArrays() {
        int[] a = {1, 2, 3, 5, 6, 7, 0, 0, 0};
        int[] b = {1, 8, 9};
        SearchingAndSorting searchingAndSorting = new SearchingAndSorting();
        searchingAndSorting.mergeSortedArrays(a, b, 5);
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
        SearchingAndSorting searchingAndSorting = new SearchingAndSorting();
        searchingAndSorting.sortArrayOfString(myArray);
        for (String s : myArray)
            System.out.println(s);
    }

    public void test_searchWithEmpty_when_word_is_present() {
        SearchingAndSorting searchingAndSorting = new SearchingAndSorting();
        String[] myArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int ball = searchingAndSorting.searchWithEmpty(myArray, 0, myArray.length - 1, "ball");
        assertEquals(4, ball);
    }

    public void test_searchWithEmpty_when_word_is_not_present() {
        SearchingAndSorting searchingAndSorting = new SearchingAndSorting();
        String[] myArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int result = searchingAndSorting.searchWithEmpty(myArray, 0, myArray.length - 1, "tutu");
        assertEquals(-1, result);
    }

}