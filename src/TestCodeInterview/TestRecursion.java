package TestCodeInterview;

import CodeInterview.Recursion;
import junit.framework.TestCase;

    public class TestRecursion extends TestCase {

    public void testFibonacci() throws Exception {
        assertEquals(0, Recursion.fibonacci(0));
        assertEquals(1, Recursion.fibonacci(1));
        assertEquals(1, Recursion.fibonacci(2));
        assertEquals(2, Recursion.fibonacci(3));
        assertEquals(3, Recursion.fibonacci(4));
        assertEquals(5, Recursion.fibonacci(5));
        assertEquals(8, Recursion.fibonacci(6));
    }
}