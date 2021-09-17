/**Doubly Linked List in Java Basics */

import java.io.*;
public class DoublyLL<T> implements Iterable<T> {
    private int size=0;
    private Node<T> head = null;
    private Node<T> tail = null;

    //Internal node Class to represent Data
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;
        
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next; 
        }
    
        @Override
        public String toString(){
            return data.toString();
        }
    }
    //Empty this linked list O(n)
    public void clear() {
        //Node<T> head = head; 
        Node<T> trav = head;
        while(trav != null)
        {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = trav = tail = null;
        size = 0;   
    }
    //Return the size of Linked list 
    public int size() {
        return Node.size;
    }

    //Is this linked list is empty?
    public boolean isEmpty() {
        return size == 0;
    }

    //Add a node to the end of the linked list
    public void addLast(T elem) {
        if(isEmpty()) {
            head = tail =new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    //Add an element at the beginning of the linked list 
    public void addFirst(T elem) {
        if(isEmpty()) {
            head = tail = new Node<T>(elem, null, null);            
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    //Add an element at specified index
    public void addAt(int index, int data) throws Exception {
        if (index < 0) {
            throw new Exception("illegal index");
        } 
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size) {
            addlLast(data);
            return;
        }

        Node<T> temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }

        Node<T> newNode = new Node<T>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;

        size ++;
    }

    //check the value of first node if exists, O(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeExexption("Empty List");
        return head.data;
    }    

    //Check the last node value if exists, O(1)
    public peekLast() {
        if(isEmpty()) throw RuntimeExexption("Empty List");
        return tail.data;
    }

    //Remove the First value at the head of the linkedlist, O(1)
    public T removeFirst() {
        //Can't remove data from emty list 
        if(isEmpty()) throw new RuntimeExexption("Empty List");

        /*Extract data at the head and move the header pointer foward obe node */
        T data = head.data;
        head = head.next;
        --size;

        //If the list is empty set the tail to null
        if(isEmpty()) tail = null;

        //Memory clean up of previous node
        else head.prev = null;

        //Return the data that was removed
        return data;
    }

    //Remove the last vakue at the tail of the linkedList, O(1)
    public T removeLast() {
        //Can't remove data from empty list 
        if(isEmpty()) throw new RuntimeExexption("Empty List");

        //Extract the data at the tail and move the tail pointer backwards one node 
        T data = tail.data;
        tail = tail.prev;
        --size;

        //If the list is empty set the head to NULL
        if(isEmpty()) head = null;

        //Memory clean up of the node that was removed
        else tail.next = null;

        //Return the data that was removed
        return data;
    }

    //Remove the arbitary node from the linkedlist, O(1)
    private T remove(Node<T> node) {
        /*If the node is somewhere either at head and tail handle independentlty*/
        if(node.prev == null) return removeFirst();
        if(node.next  == nill) return removeLast();

        //Make the pointer of the adjsent node skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        //Temporarily store data we want to return 
        T data = node.data;

        //Memory clean up
        node.data  = null;
        node = node.prev = node.next = null;

        --size;

        //Return the data we just removed
        return data;
    }

    //Remove a node at a particular index, O(N) 
    public t removeAt(int index) {
        //Make sure the index provided is valid 
        if(index < 0 || index >=size) { 
            throw new IllegalArgumentException();
        }    

        int i;
        Node<T> trav;

        //Search from the front of the linkedlist
        if(index < size/2) {
            for(i = 0, trav = head; i != index; i++) {
                trav = trav.next;
        }
        //Search from the End of the linkedlist
        } else {
            for(i = size-1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }

        return remove(trav);
    }

    //Remove aparticular value in the linkedlist, O(N)
}