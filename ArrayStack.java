import java.util.Arrays;

/**
   A class that implements a stack by using a fixed-size array.
   @author Jordan Skaar
   @version 1.0
*/

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;                          // array of stack entries
    private int topIndex;                       // index of top entry
    private int numberOfEntries;                // number of entries in the stack
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;
    
    // Default constructor
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
        numberOfEntries = 0;
    }
    
    // Overloaded constructor
    public ArrayStack(int initialCapacity) {
        checkCapacity(initialCapacity);
        // Cast is safe because array has null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        numberOfEntries = 0;
        initialized = true;
    }
    
    public void push(T newEntry) {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
        numberOfEntries++;
    }
    
    public T pop() throws EmptyStackException {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            numberOfEntries--;
            return top;
        }
    }
    
    public T peek() throws EmptyStackException {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    }
    
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    public int getLength() {
        return numberOfEntries;
    }
    
    public void clear() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        else {
            while (!isEmpty()) {
                pop();
            }
        }
    }
    
    public T[] toArray() {
        checkInitialization();
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = stack[i+1];
        }
        return result;
    }
    
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("Array Stack object is not initialized properly.");
        }
    }
    
    private void ensureCapacity() {
        if (topIndex == stack.length - 1) {
            // array is too full, double it's size
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }
    
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose capacity"
                + "exceeds allowed maximum of " + MAX_CAPACITY);
    }
}