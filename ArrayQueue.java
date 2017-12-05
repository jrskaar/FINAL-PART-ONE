/**
   A class that implements a queue by using a circular array.
   @author Jordan Skaar
   @version 1.0
*/

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] Queue;              // circular array with one unused location
    private int frontIndex;
    private int backIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;
    
    // Default constructor
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    // Overloaded constructor
    public ArrayQueue(int initialCapacity) {
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[initialCapacity + 1];
        Queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        initialized = true;
    }
    
    public void enqueue (T newEntry) {
        checkInitialization();
        ensureCapacity();
        backIndex = (backIndex + 1) % Queue.length;
        Queue[backIndex] = newEntry;
    }
    
    public T dequeue() throws EmptyQueueException {
        checkInitialization();
        if (isEmpty())
            throw new EmptyQueueException();
        else {
            T front = Queue[frontIndex];
            Queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % Queue.length;
            return front;
        }
    }
  
    public T getFront() throws EmptyQueueException {
        checkInitialization();
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return Queue[frontIndex];
    }
  
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % Queue.length);
    }
  
    public void clear() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        else {
            while (!isEmpty()){
                T front = dequeue();
            }
            T front = null;
        }
    }
    
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("Array Stack object is not initialized properly.");
        }
    }
    
    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % Queue.length)) {
            // array is full, double it's size
            T[] oldQueue = Queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[])new Object[newSize];
            Queue = tempQueue;
            for (int i = 0; i < oldSize - 1; i++) {
                Queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
        frontIndex = 0;
        backIndex = oldSize - 2;
        }
    }
    
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list whose capacity"
                + "exceeds allowed maximum of " + MAX_CAPACITY);
    }
}