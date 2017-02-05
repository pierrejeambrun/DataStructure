package All;

import sun.awt.image.IntegerInterleavedRaster;

import java.util.ArrayList;
import java.util.Stack;

public class CodeInterviewStacksAndQueues {
    public static void main(String[] args) {
        MinStack minQueue = new MinStack();
        System.out.println(minQueue.min);
        minQueue.push(2);
        System.out.println(minQueue.min());
        minQueue.peek();
        minQueue.pop();
        System.out.println(minQueue.min());
    }

    public static class MinStack {
        ArrayList<Integer> min;
        ArrayList<Integer> myArray;

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
        ArrayList<Stack<Integer>> myArray;
        int stackLimit;
        int currentstack = 0;

        public SetOfStacks(int stackLimit) {
            this.myArray = new ArrayList<>();
            myArray.add(new Stack<>());
            this.stackLimit = stackLimit;
        }

        public void push(int i) {
            if (myArray.get(myArray.size() - 1).size()  < stackLimit) {
                myArray.get(myArray.size() - 1).push(i);
            } else {
                myArray.add(new Stack<>());
                this.push(i);
            }
        }
        public int pop() {
            if(currentstack == 0 && myArray.get(myArray.size() - 1).size() == 0)
                throw new ArrayIndexOutOfBoundsException("You pop too much");
            if(myArray.get(myArray.size() - 1).size()>0) {
                 return myArray.get(myArray.size() - 1).pop();
            }else{
                myArray.remove(myArray.size()-1);
              return this.pop();
            }
        }

        public int peek() {
            return myArray.get(myArray.size() - 1).peek();
        }
    }
}
