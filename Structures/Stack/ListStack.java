/**Linkrdlist implementation of stack */
public class ListStack<T>  implements Iterable<T> , Stack<T>{
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    //Create an empty stack 
    public ListStack() {}

    //create astack with a initial element
    public Liststack(T firstelem) {
        push(firstelem);
    } 

    //Return the number of elements in the stack
    public int size() {
        return list.size();
    }

    //Check if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    //push an element on the Stack
    public void push (T elem) {
        list.addLast(elem);
    }
    
    //pop element of the Stack
    public T pop() {
        if(isEmpty())  throw new java.util.EmptyStackException();
        return list.removeLast(); 
    }

    //peek at the top of the Stack without removing the element
    public T peek() {
        if(isEmpty())  throw new java.util.EmptyStackException();
        return list.peekLast(); 
    }

    //Search for the element  starting from top of the stack
    //Return - 1 if element is not found 
    public int search(T elem) {
        return list.lastIndexOf(elem);
    }  

    //Allow users to iterate through the stack using a iterator 
    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
