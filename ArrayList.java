public class ArrayList<E> implements List<E>{   
    //instance variables
    public static final int CAPACITY = 4;  //default array capacity
    private E[] data;                      //generic array used for storage
    private int size = 0;                  //current number of elements
    
    //constructors
    public ArrayList() {
        this(CAPACITY); //constructs list with default capacity
    }
    public ArrayList(int capacity){ //constructs list with given capacity
        data = (E[]) new Object[capacity]; //safe cast; compiler may give warning   
    }
    
    //public methods
    /**Returns the number of elements in the array list. */
    public int size() {
        return size;
    }
    /**Returns whether the array list is empty. */
    public boolean isEmpty() {
        return size==0;
    }
    /**Returns(but does not remove) the element at index i. */
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }
    /**Replaces the element at index i with e, and returns the replaced element. */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }
    /**Inserts element e to be at index i, shifting all subsequent elements late. */
    public void add(int i, E e) throws IndexOutOfBoundsException,
                                       IllegalStateException {
        checkIndex(i, size + 1);
        if(size == data.length)         //not enough capacity
            resize(2 * data.length);               //increase size
            //throw new IllegalStateException("Array is full");
        for (int k=size-1; k>=i; k--)   //start by shifting rightmost
            data[k+1] = data[k];
        data[i] = e;                    //ready to place the new element
        size++;
    }
    /**Inserts element e at the end of list 
     * @param e element to add
     */   
    public void add(E e) throws IndexOutOfBoundsException,
                                       IllegalStateException {
        if(size == data.length)         //not enough capacity
            resize(2 * data.length);               //increase size
            //throw new IllegalStateException("Array is full");;
        data[size] = e;                    //ready to place the new element
        size++;
    }
    /**Removes/returns the element at index i, shifting subsequent elements earlier 
     * @param i index to remove
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k=i; k < size-1; k++) //shifts elements to fill hole
            data[k] = data[k+1];
        data[size-1] = null;        //helps garbage collection
        size--;
        if (size < data.length / 2)
            resize(data.length / 2);
        return temp;
    }
    //utility method
    /** Checks whether the given index is in the range [0, n-1]. 
     *  @param i index to check (low)
     *  @param n index of size (high)
     */
    
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >=n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
    
    /** Compares two array lists individual element and position to see if equal 
     * @param a ArrayList to compare
     * @return true/false
     */
    public boolean equals(ArrayList a) { 
        for (int i = 0; i<size; i++)
            if(this.get(i).toString() != a.get(i).toString()){
                return false;
            }
        return true;
    }        
    
    /** Creates a copy of arraylist with higher/lower capacity (used dynamically)
     *  @param capacity new capacity of list
     */
    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        data = temp;
    }
    /** Creates a string representation of ArrayList
     *  @return string representation of ArrayList
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<size; i++){
            sb.append(this.get(i));
            if (i == size-1){
                return sb.toString();
            } else {
              sb.append(" ");  
            }
        }
        return sb.toString();
    }
}