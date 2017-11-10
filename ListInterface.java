/**
    An interface of an ADT LIST
    @author Jordan Skaar
    @version 1.0
*/

public interface ListInterface<T> {
    /**
        Add an entry to the end of the list
        The list size will be increased by 1
        Other item positions will be unaffected
        @param item. The object to be added
    */
    public void add(T item);
    
    /**
        Add an entry to the specified position of the list
        The list size will be increased by 1
        Other items at or below given index will be unaffected
        @param position. The location the item should be added
        @param item. The object to be added
        @throws indexOutOfBoundsException if either
            position < 1 or position > getLength() + 1
    */
    public void add(int position, T item);
    
    /**
        Remove an item from a specified location in the list
        The list size will be decreased by 1
        The positions of items with positions at or above the
            specified position will be decreased by 1
        @param position. The position where an item should be removed
        @return item that was removed
    */
    public T remove(int position);
    
    /**
        View the item at a specified position
        List size does not change
        Item positions do not change
        @param position. The position for the item to be viewed
        @return item that was viewed
    */
    public T view(int position);
    
    /**
        Removes every item in the list
        @return item that was viewed
    */
    public void clear();
    
    /**
        Replace the item at a specified position with the specified object
        List size does not change
        Item positions do not change
        @param position. The position for the item to be replaced
        @param item. The item to add to the list
        @return item that was replaced
    */
    public T replace(int position, T item);
    
    /**
        Checks whether an item is in the list
        List size does not change
        Item positions do not change
        @param item. The item to be checked for in the list
        @return item that was checked for in the list
    */
    public T contains(T item);
    
    /**
        See how long the list is
        List size does not change
        Item positions do not change
        @return length of list
    */
    public int getLength();
    
    /**
        See if list is empty
        List size does not change
        Item positions do not change
        @return whether list is empty or not
    */
    public boolean isEmpty();