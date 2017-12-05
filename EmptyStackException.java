/**
    EmptyStackException: exception thrown by ArrayStack.java
    when stack is empty and pop or peek methods are called.
*/

public class EmptyStackException extends Exception {
    public EmptyStackException() {
        super("Error: Stack is already empty.");
    }
}