/**
 * Interface for a priority queue Heap that holds house object.
 * Provides methods for adding house, getting the most expensive house, clearing the Array,
 * getting the length of the Array, and checking if the Array is empty.
 */
public interface PriorityQueue {

    /**
     * Adds a house to the priority queue Array based on the value of the house.
     *
     * @param a house object that will be added.
     */
    void add(House a);

    /**
     * Gets the most expensive house in the priority queue Array and removes it.
     *
     * @return The most expensive house in the Array.
     */
    House getMostExpensive();

    /**
     * Clears the priority queue Array.
     */
    void clear();

    /**
     * Gets the length of the priority queue Array.
     *
     * @return The length of the Array.
     */
    int getLength();

    /**
     * Checks if the priority queue Array is empty.
     *
     * @return True if the Array is empty, false otherwise.
     */
    boolean isEmpty();
}