/**
 *This class represents PriorityQueueHeap Object with House Array and length fields.
 * Provides Add, Swap, heapifyUp, heapifyDown, deep-copy and getMostExpensive methods.
 */
public class PriorityQueueHeap implements PriorityQueue {

    /**
     * Fields of the PriorityQueueHeap class.
     */
    private House[] houseArray;
    private int length;

    /**
     * Default constructor that initializes House Array to size 1000 and length to value 0.
     */
    public PriorityQueueHeap() {
        houseArray = new House[1000];
        length = 0;
    }

    /**
     * Deep copy constructor.
     * @param other PriorityQueueHeap object to be deeply copied.
     */
    public PriorityQueueHeap(PriorityQueueHeap other) {
        houseArray = new House[other.getHouseArray().length];

        int count = 0;
        for (House h : other.houseArray) {
            if(h != null) {
                houseArray[count] = h.deepCopy();
            }
            count++;
        }
        length = other.length;
    }

    /**
     * Swaps two values into each other.
     * @param index1 value to be swap.
     * @param index2 value to be swap.
     */
    public void swap(int index1, int index2) {
        House temp = houseArray[index1];
        houseArray[index1] = houseArray[index2];
        houseArray[index2] = temp;
    }

    /**
     * Gets the left child index of a given index.
     * @param index parent index value.
     * @return returns the left child index value.
     */
    private int getLeftChildIndex(int index) {
        return (2 * index + 1);
    }

    /**
     * Gets the right child index of a given index.
     * @param index parent index value.
     * @return returns the right child index value.
     */
    private int getRightChildIndex(int index) {
        return (2 * index + 2);
    }

    /**
     * Adds a House object into the House Array with respect to max heap property.
     * @param a house object that will be added to the Array.
     */
    @Override
    public void add(House a) {
        House tempHouse = new House(a);
        houseArray[length] = tempHouse;
        heapifyUp(length);
        length++;
    }


    /**
     * Swaps parent index with either left or right child index,
     * until heap max property is not violated.
     * @param a the parent index to be swapped
     */
    public void heapifyDown(int a) {
        int index = a;
        while (true) {
            int leftChild = getLeftChildIndex(index);
            int rightChild = getRightChildIndex(index);
            int largest = index;

            if (leftChild < length && houseArray[leftChild].getValue() > houseArray[largest].getValue()) {
                largest = leftChild;
            }

            if (rightChild < length && houseArray[rightChild].getValue() > houseArray[largest].getValue()) {
                largest = rightChild;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }


    /**
     * Swaps child index with parent index until parent index is greater.
     * @param length the child index to be swapped.
     */
    public void heapifyUp(int length) {
        int current = length;
        int currentParent = (int) (double) ((current - 1) / 2);

        while (current > 0 && houseArray[currentParent].getValue() < houseArray[current].getValue()) {
            House temp = new House(houseArray[currentParent]);
            houseArray[currentParent] = houseArray[current];
            houseArray[current] = temp;
            current = currentParent;
            currentParent = (currentParent - 1) / 2;
        }
    }


    /**
     * Gets the most expensive house in the House Array and removes it from the array.
     * @return most expensive house in the array.
     */
    @Override
    public House getMostExpensive() {
        House temp = new House();
        temp = houseArray[0];
        houseArray[0] = houseArray[length - 1];
        length--;
        heapifyDown(0);

        return temp;
    } //should remove the maximum value house from the heap and return it from the method.


    /**
     * clears the House Array by setting the size to 0.
     */
    @Override
    public void clear() {
        houseArray = new House[0];
    }

    /**
     * Gets the length of the PriorityQueueHeap Object.
     * @return length of the object.
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Checks the length of PriorityQueueHeap Object.
     * @return returns true if length is 0, false if not.
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Gets the House Array.
     * @return returns House Array.
     */
    public House[] getHouseArray() {
        return houseArray;
    }

    /**
     * Deep copies called PriorityQueueHeap object
     * @return returns new PriorityQueueHeap object with called PriorityQueueHeap objects values.
     */
   public PriorityQueueHeap deepCopy() {
       return new PriorityQueueHeap(this);
   }

}
