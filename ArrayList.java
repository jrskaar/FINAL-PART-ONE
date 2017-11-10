public class ArrayList<T> implements ListInterface<T> {
    private T[] List;
    private int numEntries;
    private boolean initialized = false;
    private static final ARRAY_SIZE = 10;
    
    public ArrayList() {
        this(ARRAY_SIZE);
    }
    
    public void add(T newEntry) {
        checkInitialization();
        List[numEntries + 1] = newEntry;
        numEntries++;
        // ensureCapacity();
    }
    
    public void add(int position, T newEntry) {
        checkInitialization();
        numEntries++;
        for (int i = numEntries; i > position; i--) {
            List[i+1] = List[i];
        }
        List[position] = newEntry;
        // ensureCapacity();
    }
    
    public T remove(int position) {
        if (isEmpty())
            // throws exception
        else {
            T temp = List[position];
            for (int i = position; i < numEntries; i++) {
                List[i-1] = List[i];
            }
            numEntries--;
            return temp;
        }
    }
    
    public T view(int position) {
        return List[position];
    }
    
    public void clear() {
        for (int i = 0; i <= numEntries; i++) {
            remove(i);
        }
        return;
    }
    
    public T replace(int position, T item) {
        List[position] = item;
        return;
    }
    
    public T[] toArray() {
        checkInitialization();
        @SuppressWarnings("unchecked");
        T[] result = (T[]) new Object[numEntries];
        for (int i = 0; i < numEntries; i++) {
            result[i] = List[i+1];
        }
        return result;
    }
    
    public boolean contains(T item) {
        boolean result = false;
        for (int i = 0; i < numEntries; i++) {
            if (List[i] == item) {
                result = true;
            }
            else {
                result = false;
            }
        }
        return result;
    }
    
    public int getLength() {
        return numEntries;
    }
    
    public boolean isEmpty() {
        return numEntries == 0;
    }