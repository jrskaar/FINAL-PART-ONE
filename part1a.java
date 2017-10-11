public class ArrayStack implements StackInterface{
    private final T[] arrayStack;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int STACK_SIZE = 10;
    
    // Default constructor
    public ArrayStack(){
        this(STACK_SIZE);
        initialized = true;
    }
    
    public void push(T newEntry) {
        // push: adds a new entry
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        }
        else {
            arrayStack[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }
    
    public T pop() {
        // pop: return entry on top, remove it
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }
    
    public T peek() {
        // peek: return entry on top
    }
    
    public boolean isEmpty() {
        // check if it's empty
        return numberOfEntries == 0;
    }
    
    public void clear() {
        // removes all entries
        while (!isEmpty()) {
            pop();
        }
    }
    
    public boolean isArrayFull() {
        return numberOfEntries >= arrayStack.length;
    }
    
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("Array Stack object is not initialized properly.");
        }
    }
    
    private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = arrayStack[givenIndex];                   // Entry to remove
         int lastIndex = numberOfEntries - 1;
         arrayStack[givenIndex] = arrayStack[lastIndex];    // Replace entry to remove with last entry
         arrayStack[lastIndex] = null;                      // Remove reference to last entry
         numberOfEntries--;
		}
      
        return result;
	}
}