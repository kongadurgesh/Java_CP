package queues;

import java.util.ArrayList;

public class Deque {
    // Initialize your data structure.
    ArrayList<Integer> deque = null;
    int size = 0;
    int currentSize = 0;

    public Deque(int n) {
        // Write your code here.
        this.deque = new ArrayList<Integer>(n);
        this.size = n;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the
    // deque, and false otherwise.
    public boolean pushFront(int x) {
        // Write your code here.
        if (currentSize < size) {
            deque.add(0, x);
            currentSize++;
            return true;

        }
        return false;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the
    // deque, and false otherwise.
    public boolean pushRear(int x) {
        // Write your code here.
        if (currentSize < size) {
            deque.add(x);
            currentSize++;
            return true;

        }
        return false;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is
    // empty, otherwise returns the popped element.
    public int popFront() {
        // Write your code here.
        if (deque.isEmpty())
            return -1;
        currentSize--;
        return deque.remove(0);
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty,
    // otherwise returns the popped element.
    public int popRear() {
        // Write your code here.
        if (deque.isEmpty()) {
            return -1;
        }
        int element = deque.remove(currentSize - 1);
        currentSize--;
        return element;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() {
        // Write your code here.
        if (deque.isEmpty())
            return -1;
        return deque.get(0);
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() {
        // Write your code here.
        if (deque.isEmpty())
            return -1;
        return deque.get(currentSize - 1);
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() {
        // Write your code here.
        return currentSize == 0;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() {
        // Write your code here.
        return currentSize == size;

    }
}
