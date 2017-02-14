package CodeInterview;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class StacksAndQueues {
    public static class MinStack {
        public ArrayList<Integer> min;
        public ArrayList<Integer> myArray;

        public MinStack() {
            this.min = new ArrayList<>();
            this.min.add(Integer.MAX_VALUE);
            this.myArray = new ArrayList<>();
        }

        public void push(int i) {
            myArray.add(i);
            if (i < min.get(min.size() - 1)) {
                min.add(i);
            }
        }

        public int pop() {
            Integer lastElement = this.myArray.get(myArray.size() - 1);
            this.myArray.remove(myArray.size() - 1);
            if (lastElement == min.get(min.size() - 1)) {
                min.remove(min.size() - 1);
            }
            return lastElement;
        }

        public int peek() {
            return this.myArray.get(myArray.size() - 1);
        }

        public int min() {
            return min.get(min.size() - 1);
        }
    }

    public static class SetOfStacks {
        public ArrayList<Stack> myArray;
        public int stackLimit;
        public int currentstack = 0;

        public SetOfStacks(int stackLimit) {
            myArray = new ArrayList<>();
            myArray.add(new Stack<>());
            this.stackLimit = stackLimit;
        }

        public void push(int i) {
            if (myArray.get(myArray.size() - 1).size() < stackLimit)
                myArray.get(myArray.size() - 1).push(i);
            else {
                myArray.add(new Stack<Objects>());
                push(i);
            }
        }

        public Object pop() {
            if (currentstack == 0 && myArray.get(0).size() == 0)
                throw new ArrayIndexOutOfBoundsException("You pop too much");
            if (myArray.get(myArray.size() - 1).size() > 0) {
                return myArray.get(myArray.size() - 1).pop();
            } else {
                myArray.remove(myArray.size() - 1);
                return pop();
            }
        }

        public Object peek() {
            return myArray.get(myArray.size() - 1).peek();
        }
    }

    public static class MyQueue<T> {
        public Stack<T> stack1;
        public Stack<T> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(T object) {
            stack1.push(object);
        }

        public T pop() {
            if (!stack2.isEmpty())
                return stack2.pop();
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }

        public T peek() {
            if (!stack2.isEmpty())
                return stack2.peek();
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.peek();
        }
    }

    // Sort a stack only with the function of the stack push pop peek isEmpty.
    public Stack<Integer> sortInAscendingOrder(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (s.size() != 0) {
            int temp = s.pop();
            while (!r.isEmpty() && temp > r.peek())
                s.push(r.pop());
            r.push(temp);
        }
        return r;
    }
}
