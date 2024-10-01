public class PriorityQueueHeap implements PriorityQueue {
    private House[] houseArray;
    private int length;

    //Default constructor
    public PriorityQueueHeap() {
        houseArray = new House[1000];
        length = 0;
    }

    //Copy constructor (Deep Copy)
   public PriorityQueueHeap(PriorityQueueHeap other) {
        houseArray = new House[other.getHouseArray().length];

        int count = 0;
        for (House h : other.houseArray) {
            houseArray[count] = h;
            count++;
        }
        length = other.length;
    }


    @Override
    public void add(House a) {
        House tempHouse = new House(a);
//        int parent = (int) Math.floor(length - 1) / 2;
//        int leftChild = (int) Math.floor(2 * (parent) + 1);
//        int rightChild = (int) Math.floor(2 * (parent) + 2);


        houseArray[length] = tempHouse;
//        if (length == 0) {
//            houseArray[length] = tempHouse;
//        } else if (houseArray[leftChild] == null) {
//            houseArray[leftChild] = tempHouse;
//        } else if (houseArray[leftChild] != null && houseArray[rightChild] == null) {
//            houseArray[rightChild] = tempHouse;
//        }
        heapfiyUp(length);
        length++;
    }

    public void heapfiyUp(int length) {
        int current = length;
        int currentParent = (int) (double) ((current - 1) / 2);
        while (current > 0 && houseArray[currentParent].getValue() > houseArray[current].getValue()) {
            House temp = new House(houseArray[currentParent]);
            houseArray[currentParent] = houseArray[current];
            houseArray[current] = temp;
            current = currentParent;
            currentParent = (currentParent - 1) / 2;
        }
    }

    @Override
    public House getMostExpensive() {
        return null;
    } //should remove the maximum value house from the heap and return it from the method.

    @Override
    public void clear() {
        houseArray = new House[0];
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public House[] getHouseArray() {
        return houseArray;
    }

    public void setHouseArray(House[] houseArray) {
        this.houseArray = houseArray;
    }

    public int getLenght() {
        return length;
    }

    public void setLength() {
        this.length = length;
    }
}
