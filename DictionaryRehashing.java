import java.util.Iterator;

public class DictionaryRehashing<K,V> implements DictionaryInterface<K, V> {
    private int numEntries;
    private static final int DEFAULT_CAPACITY = 5;  // Must be prime
    private static final int MAX_CAPACITY = 10000;
    // Hash table:
    private TableEntry<K,V>[] hashTable;
    private int tableSize;      // Must be prime
    private static final int MAX_SIZE = 2 * MAX_CAPACITY;
    private boolean initialized = false;
    private static final double MAX_LOAD_FACTOR = 0.5;  // Fraction of hash table that can be filled
    
    // default consructor
    public DictionaryRehashing() {
        this(DEFAULT_CAPACITY);
    }
    
    // overloaded constructor
    public DictionaryRehashing(int initialCapacity) {
        checkCapacity(initialCapacity);
        numEntries = 0;         // Dictionary is empty so far
        // Set up hash table:
        // Initial size of hash table is same as initialCapacity if it is prime
        int tableSize = getNextPrime(initialCapacity);      // gets next prime number
        checkSize(tableSize);   // Check for max array size
        @SuppressedWarnings("unchecked")
        TableEntry<K,V>[] temp = (TableEntry<K,V>[])new TableEntry[tableSize];
        hashTable = temp;
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
        // add
    }
   
    /** Removes a specific entry from this dictionary.
        @param key  An object search key of the entry to be removed.
        @return  Either the value that was associated with the search key
                or null if no such object exists. */
    public V remove(K key) {
        // remove
    }
   
    /** Retrieves from this dictionary the value associated with a given
        search key.
        @param key  An object search key of the entry to be retrieved.
        @return  Either the value that is associated with the search key
                or null if no such object exists. */
    public V getValue(K key) {
        // getValue
    }
   
    /** Sees whether a specific entry is in this dictionary.
        @param key  An object search key of the desired entry.
        @return  True if key is associated with an entry in the dictionary. */
    public boolean contains(K key) {
        // constains
    }
   
    /** Creates an iterator that traverses all search keys in this dictionary.
        @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
    public Iterator<K> getKeyIterator() {
        // getKeyIterator
    }
   
    /** Creates an iterator that traverses all values in this dictionary.
        @return  An iterator that provides sequential access to the values
                in this dictionary. */
    public Iterator<V> getValueIterator() {
        // getValueIterator;
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
        // clear
    }
}

private class Entry<S,T> {
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