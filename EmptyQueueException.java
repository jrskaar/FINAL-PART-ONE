/**
    EmptyQueueException: exception thrown by ArrayQueue.java
    when queue is empty and dequeue or getFront methods are called.
*/

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Error: Queue is already empty.");
    }
}