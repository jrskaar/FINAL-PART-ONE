/**
    A class implementing an ADT Queue using a doubly linked node.
    @author Jordan Skaar
    @version 1.0
*/

public class DLDeque<T> implements DequeInterface<T> {
    private DLNode head;        // pointer to front of line
    private DLNode tail;        // pointer to end of line
    
    public DLDeque() {
        head = null;
        tail = null;
        // don't need to create array yet since nobody is in line.
    }
    
    public DLDeque(first person/thing in line) {
        // FILL IN LATER
        
    }
    
    public void addToFront(T newEntry) {
        // create a new node
        // set it to the front of the line
        // fix all pointers
        DLNode newNode = new DLNode(prev, next, newEntry);
        head = newNode;
        
    }
    
    public void addToBack(T newEntry) {
        // create new node
        // set it to back of line
        // fix all pointers
        DLNode newNode = new DLNode(prev, next, newEntry);
        tail = newNode;
        
    }
    
    public T removeFront() {
        // check if data is there. If NOT, throw exception
        // set temporary variable = node to be removed
        // delete data in DLNode
        // move head to next node if there is one
        // ONLY IF there is a DLNode that head is pointing to, move its previous to null
        // return object removed
        if (isEmpty) {
            // throw Exception
        }
        temp = head;
        head = temp.getNext();      // ?
        
    }
    
    public T removeBack() {
        // check if data is there. IF NOT, throw exception
        // hold data in temp variable
        // delete data in DLNode (for security)
        // move tail to previous
        // ONLY IF there is a DLNode that head is pointing to, move its next to null
        if (isEmpty) {
            // throw Exception
        }
        temp = tail;
        tail = temp.getPrev();      // ?
        
    }
    
    public T getFront(){
        // blah
    }
    
    public T getBack(){
        // blah
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void clear() {
        // blah
    }
}

class DLNode <T> {
    private T data;
    private DLNode previous;
    private DLNode next;
    DLNode (T d, Node prev, Node n) {
        data = d;
        previous = prev;
        next = n;
    }
    
    // get node data
    public T getData() {
        return data;
    }
    
    // get previous node
    public DLNode getPrev() {
        return previous;
    }
    
    public DLNode getNext() {
        return next;
    }
}