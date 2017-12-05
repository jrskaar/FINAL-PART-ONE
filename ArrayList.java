import java.util.Arrays;

/**
   A class that implements a list by using a fixed-size array.
   @author Jordan Skaar
   @version 1.0
*/

public class ArrayList<T> implements ListInterface<T> {
    private T[] List;                       // array of list entries
    private int numEntries;                 // number of entries
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;
    
    // Default constructor
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    // Overloaded constructor
    public ArrayList(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity];
        List = tempList;
        numEntries = 0;
        initialized = true;
    }
    
    public void add(T newEntry) {
        checkInitialization();
        numEntries++;
        List[numEntries] = newEntry;
        ensureCapacity();
    }
    
    public void add(int position, T newEntry) {
        checkInitialization();
        if ((position >= 1) && (position <= numEntries + 1)) {
            numEntries++;
            if (position <= numEntries)
                for (int i = numEntries; i > position; i--) {
                    List[i+1] = List[i];
                }
            List[position] = newEntry;
            ensureCapacity();
        }
        else
            throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds");
    }
    
    public T remove(int position) {
        checkInitialization();
        if ((position >= 1) && (position <= numEntries)) {
            assert !isEmpty();
            T result = List[position];
            for (int i = position; i < numEntries; i++) {
                List[i] = List[i + 1];
            }
            numEntries--;
            return result;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }
    
    public T getEntry(int position) {
        checkInitialization();
        if ((position >= 1) && (position <= numEntries)) {
            assert !isEmpty();
            return List[position];
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }
    
    public void clear() {
        for (int i = 0; i <= numEntries; i++) {
            remove(i);
        }
        return;
    }
    
    public T replace(int position, T newEntry) {
        checkInitialization();
        if ((position >= 1) && (position <= numEntries)) {
            assert !isEmpty();
            T originalEntry = List[position];
            List[position] = newEntry;
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }
    
    public boolean contains(T anEntry) {
        checkInitialization();
        boolean found = false;
        int i = 1;
        while (!found && (i <= numEntries)) {
            if (anEntry.equals(List[i]))
                found = true;
        i++;
        }
        return found;
    }
    
    public int getLength() {
        return numEntries;
    }
    
    public boolean isEmpty() {
        return numEntries == 0;
    }
    
    public T[] toArray() {
        checkInitialization();
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numEntries];
        for (int i = 0; i < numEntries; i++) {
            result[i] = List[i+1];
        }
        return result;
    }
    
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("Array Stack object is not initialized properly.");
        }
    }
    
    private void ensureCapacity() {
        int capacity = List.length - 1;
        if (numEntries >= capacity) {
            // array is too full, double it's size
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            List = Arrays.copyOf(List, newCapacity + 1);
        }
    }
    
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list whose capacity"
                + "exceeds allowed maximum of " + MAX_CAPACITY);
    }
}