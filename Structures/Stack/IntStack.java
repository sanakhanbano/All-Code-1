public class IntStack implements Stack<Integer> {
    
    private int[] ar;
    private int pos = 0;
    
    /**maxsize is max number of items that can be in the queue at given time*/
    public IntStack(int maxsize) {
        ar = new int[maxsize];
    }
    //Return the number of elements insize the stack  
    //@Override
    public int size() {
        return pos;
    }
    //return true/false on whether stack is empty
    //@Override
    public boolean isEmpty() {
        return pos == 0;
    }
    //Return the element at top of the Stack
    @Override
    public Integer peek() {
        return ar[pos-1];
    }
    //Add an element at the top of the Stack
    @Override
    public void push(Integer value) {
        ar[pos++] = value;                
    }

    @Override
    public Integer pop() {
        return ar[--pos];
    }

    //Example usage
    public static void main(String[] args) {
        IntStack s = new IntStack(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("Stack push elements\n" + s);
        
        System.out.println("Stack pop elements");        
        System.out.println(s.pop()); //5
        System.out.println(s.pop()); //4 
        System.out.println(s.pop()); //3

        s.push(33);
        s.push(44);
        s.push(54);
        System.out.println("Stack new elements\n" + s);

        //if not empty then pop
        while(!s.isEmpty()) { 
            System.out.println(s.pop());
        }
        
        benchMarkTest();
    }

    //BenchMark between IntStack vs ArrayDeque
    public static void benchMarkTest() {
        int n = 10000000;

        IntStack intstack = new IntStack(n);

        //IntStack times around 0.0324
        long start = System.nanoTime();  
        for(int i = 0; i < n; i++) intstack.push(i);   
        for(int i = 0; i < n; i++) intstack.pop();
        long end = System.nanoTime(); 
        System.out.println("Intstack time :" + (end - start) / 1e9);

        //arrayDeque around 1.048 seconds
    }

    

    
}
