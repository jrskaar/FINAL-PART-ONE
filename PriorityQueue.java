public class PriorityQueue<T extends Comparable<? super T>> {
    private int numEntries;
    private Node topItem = null;
    private Node highestPriority;
    
    public void add(T newEntry) {
        boolean result = true;
        if (isArrayFull()) {
           result = false;
        }
        else {
            Node newNode = new Node(newEntry, topItem);
            topItem = newNode;
        }
      
        return result;
    }

    public T remove() {
        Node temp = highestPriority;
        topItem = temp.getLink();
        return (T)temp.getData();
    }

    public T peek() {
        return (T)topItem.getData();
    }

    public boolean isEmpty() {
        return numEntries < 1;
    }

    public int getSize() {
        return numEntries;
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
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