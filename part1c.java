public class part1c <T> implements StackInterface <T> {
    private Node topItem = null;    // first node in stack points to null
    
    public void push(T newEntry) {
        // push: adds a new entry
        Node newNode = new Node(newEntry, topItem);
        topItem = newNode;
    }
    
    public T pop() {
        // pop: return entry on top, remove it
        // @SuppressWarnings("unchecked")
        Node temp = topItem;
        topItem = temp.getLink();
        return (T)temp.getData();
    }
    
    public T peek() {
        // peek: return entry on top
        // @SuppressWarnings("unchecked")
        return (T)topItem.getData();
    }
    
    public boolean isEmpty() {
        // check if it's empty
        return topItem != null;
    }
    
    public void clear() {
        // removes all entries
        topItem = null;
    }
}
class Node <T> {
    private T data;
    private Node previous;
    Node (T d, Node prev) {
        data = d;
        previous = prev;
    }
    // get node data
    public T getData() {
        return data;
    }
    // get previous node
    public Node getLink() {
        return previous;
    }
}