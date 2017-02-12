package Test;

import All.CodeInterviewRecursion;
import junit.framework.TestCase;

    public class CodeInterviewRecursionTest extends TestCase {

    public void testFibonacci() throws Exception {
        assertEquals(0, CodeInterviewRecursion.fibonacci(0));
        assertEquals(1, CodeInterviewRecursion.fibonacci(1));
        assertEquals(1, CodeInterviewRecursion.fibonacci(2));
        assertEquals(2, CodeInterviewRecursion.fibonacci(3));
        assertEquals(3, CodeInterviewRecursion.fibonacci(4));
        assertEquals(5, CodeInterviewRecursion.fibonacci(5));
        assertEquals(8, CodeInterviewRecursion.fibonacci(6));
    }
}