//stack using array of objects
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{
    private int size;
    private int capacity;
    private Object[] data;  //array of object 
    //Object class root of all classes in java.lang
    //it can hold same type of object and different data types 

    public ArrayStack() {
        capacity = 16;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T elem) {
        if(size == capacity) {
            increaseCapacity();
        }
        data[size++] = elem;
    }

    //Increase capacity to store more elements
    public void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data,capacity);
    }   
    
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        T elem = (T) data[--size];
        data[size] = null;
        return elem; 
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if(isEmpty()) { throw new EmptyStackException(); }
        return (T) data[size - 1]; //return element at the top of the stack
    }   
}
