import java.util.ArrayList;
public class DynamicArray {
    /*
    Resizeable array, such as an ArrayList in Java.
     */
    private int[] arr;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }
    // O(n), n = capacity

    public int get(int i) {
        return arr[i];
    }
    // O(1)

    public void set(int i, int n) {
        arr[i] = n;
    }
    // O(1)

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        arr[size] = n;
        size++;
    }
    // O(1) - avg case/ammortized

    public int popback() {
        int last_element = arr[size - 1];
        // remove last element from array
        size--;
        return last_element;
    }
    // O(1)

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity]; // creating a new array
        for (int i = 0; i < size; i++) { // copying values to new array
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    // O(n)

    public int getSize() {
        return size;
    }
    // O(1)

    public int getCapacity() {
        return capacity;
    }
    // O(1)
}
