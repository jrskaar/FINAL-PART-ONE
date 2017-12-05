import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDictionary<K extends Comparable<? super K>,V> implements DictionaryInterface<K,V> {
    private int numEntries;
    private int capacity;
    private Entry<K,V>[] dictionary;    // Array of unsorted entries
    private boolean initialized = false;
    private final static int DEFAULT_CAPACITY = 100000;
    private static final int MAX_CAPACITY = 100000;
    
    public ArrayDictionary() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayDictionary(int initialCapacity) {
        // checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        Entry<K,V>[] tempDictionary = (Entry<K,V>[])new Entry[initialCapacity];
        dictionary = tempDictionary;
        numEntries = 0;
        capacity = initialCapacity;
        initialized = true;
    }
    
    /** Adds a new entry to this dictionary. If the given search key already
        exists in the dictionary, replaces the corresponding value.
        @param key    An object search key of the new entry.
        @param value  An object associated with the search key.
        @return  Either null if the new entry was added to the dictionary
                or the value that was associated with key if that value
                was replaced. */
    public V add(K key, V value) {
        checkInitialization();
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException();
        }
        else {
            V result = null;
            int keyIndex = locateIndex(key);
            if (keyIndex < numEntries) {
                // key found
                result = dictionary[keyIndex].getValue();   // get old value
                dictionary[keyIndex].setValue(value);       // replace value
            }
            else {      // key not found
                // add at end of array
                dictionary[numEntries] = new Entry<>(key, value);
                numEntries++;
                // ensureCapacity();
            }
            return result;
        }
    }
    
    private int locateIndex (K key) {
        int index = 0;
        while ((index < numEntries) && (!key.equals(dictionary[index].getKey()))) {
            index++;
        }
        return index;
    }
   
    /** Removes a specific entry from this dictionary.
        @param key  An object search key of the entry to be removed.
        @return  Either the value that was associated with the search key
                or null if no such object exists. */
    public V remove(K key) {
        checkInitialization();
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numEntries) {
            // key found
            result = dictionary[keyIndex].getValue();
            dictionary[keyIndex] = dictionary[numEntries-1];
            dictionary[numEntries-1] = null;
            numEntries--;
        }
        return result;
    }
   
    /** Retrieves from this dictionary the value associated with a given
        search key.
        @param key  An object search key of the entry to be retrieved.
        @return  Either the value that is associated with the search key
                 or null if no such object exists. */
    public V getValue(K key) {
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numEntries) {
            // key found
            result = dictionary[keyIndex].getValue();
        }
        return result;
    }
   
    /** Sees whether a specific entry is in this dictionary.
        @param key  An object search key of the desired entry.
        @return  True if key is associated with an entry in the dictionary. */
    public boolean contains(K key) {
        boolean result = false;
        int keyIndex = locateIndex(key);
        if (keyIndex < numEntries) {
            // key found
            result = true;
        }
        return result;
    }
   
    /** Creates an iterator that traverses all search keys in this dictionary.
        @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
    public Iterator<K> getKeyIterator() {
        // Iterator
        return null;
    }
   
    /** Creates an iterator that traverses all values in this dictionary.
        @return  An iterator that provides sequential access to the values
                in this dictionary. */
    public Iterator<V> getValueIterator() {
        // Iterator
        return null;
    }
   
    /** Sees whether this dictionary is empty.
        @return  True if the dictionary is empty. */
    public boolean isEmpty() {
        return numEntries == 0;
    }
   
    /** Gets the size of this dictionary.
        @return  The number of entries (key-value pairs) currently
                in the dictionary. */
    public int getSize() {
        return numEntries;
    }
   
    /** Removes all entries from this dictionary. */
    public void clear() {
        while (numEntries > 0) {
            dictionary[numEntries] = null;
            numEntries--;
        }
        return;
    }
    
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("Array Stack object is not initialized properly.");
        }
    }
    
    private void ensureCapacity() {
        if (numEntries == capacity) {
            // array is full, double it's size
            int newCapacity = capacity * 2;
            checkCapacity(newCapacity);
            capacity = newCapacity;
            dictionary = Arrays.copyOf(dictionary, newCapacity + 1);
        }
    }
    
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list whose capacity"
                + "exceeds allowed maximum of " + MAX_CAPACITY);
    }
    
    private class Entry<K,V> {
        private K key;
        private V value;
    
        private Entry(K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
        }
    
        private K getKey() {
            return key;
        }
    
        private V getValue() {
            return value;
        }
    
        private void setValue(V newValue) {
            value = newValue;
        }
    }
}