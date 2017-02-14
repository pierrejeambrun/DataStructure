package TestCodeInterview;

import CodeInterview.StacksAndQueues;
import junit.framework.TestCase;

import java.util.Stack;

public class TestStacksAndQueues extends TestCase {
    public void test_the_whole_class_CodeInterviewStacksAndQueues() throws Exception {
        StacksAndQueues.MinStack minQueue = new StacksAndQueues.MinStack();
        assertEquals(2147483647, minQueue.min());
        minQueue.push(2);
        assertEquals(2, minQueue.min());
        minQueue.peek();
        minQueue.pop();
        assertEquals(2147483647, minQueue.min());
        StacksAndQueues.SetOfStacks setOfStacks = new StacksAndQueues.SetOfStacks(3);
        assertEquals(1, setOfStacks.myArray.size());
        setOfStacks.push(3);
        setOfStacks.push(3);
        setOfStacks.push(3);
        assertEquals(1, setOfStacks.myArray.size());
        setOfStacks.push(4);
        setOfStacks.push(4);
        setOfStacks.push(4);
        assertEquals(2, setOfStacks.myArray.size());
        assertEquals(4, setOfStacks.pop());
        assertEquals(4, setOfStacks.pop());
        assertEquals(4, setOfStacks.pop());
        assertEquals(3, setOfStacks.pop());
        StacksAndQueues.MyQueue<Integer> myQueue = new StacksAndQueues.MyQueue<>();
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        assertEquals(3, (int) myQueue.pop());
        assertEquals(4, (int) myQueue.pop());
        myQueue.push(6);
        assertEquals(5, (int) myQueue.pop());
        assertEquals(6, (int) myQueue.peek());
        assertEquals(6, (int) myQueue.peek());
    }

    public void test_the_sortInAscendingOrder_should_sort_my_stack(){
        StacksAndQueues stacksAndQueues = new StacksAndQueues();
        Stack<Integer> myStack = new Stack<>();
        myStack.push(7);
        myStack.push(6);
        myStack.push(8);
        myStack.push(1);
        myStack.push(3);
        Stack<Integer> sortedStack = stacksAndQueues.sortInAscendingOrder(myStack);
        assertEquals(1, (int) sortedStack.pop());
        assertEquals(3, (int) sortedStack.pop());
        assertEquals(6, (int) sortedStack.pop());
        assertEquals(7, (int) sortedStack.pop());
        assertEquals(8, (int) sortedStack.pop());
    }


}