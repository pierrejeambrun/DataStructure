package CodeInterview;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ArrayList<String> myArray = new ArrayList<>();
        myArray.add("a");
        myArray.add("b");
        myArray.add("c");
        myArray.add("d");
        myArray.add("a");
        myArray.add("a");
        myArray.add("a");
        myArray.add("a");
        linkedList.removeDuplicateNoBuffer(myArray);
        linkedList.getTheNLastElement(null, 1);
    }

    // If we cannot use a buffer we can use two pointers, one if the current node you want to search
    // duplicate for, the other one iterates through the previous node. If you find another value, remove, else move forward.
    // see below.
    public ArrayList removeDuplicat(ArrayList myArray) {
        ArrayList stock = new ArrayList();
        Iterator iterator = myArray.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (stock.contains(next)) {
                continue;
            }
            stock.add(next);
        }
        return stock;
    }

    public void removeDuplicateNoBuffer(ArrayList myArray) {
        int size = myArray.size();
        for (int current = 0; current < size; current++) {
            for (int seeker = 0; seeker < current; seeker++) {
                if (myArray.get(current).equals(myArray.get(seeker))) {
                    myArray.remove(current);
                    size--;
                    current--;
                    break;
                }
            }
        }
    }

    public ArrayList getTheNLastElement(ArrayList myArray, int n) {
        if (myArray == null || myArray.isEmpty() || myArray.size() < n) {
            System.out.println("problem with the value, check the input Array, and the number of element you want");
            return null;
        }
        Iterator iterator1 = myArray.iterator();
        Iterator iterator2 = myArray.iterator();
        for (int i = 0; i < n; i++) {
            iterator1.next();
        }

        while (iterator1.hasNext()) {
            iterator1.next();
            iterator2.next();
        }
        ArrayList result = new ArrayList();
        while (iterator2.hasNext()) {
            result.add(iterator2.next());
        }
        return result;
    }


}