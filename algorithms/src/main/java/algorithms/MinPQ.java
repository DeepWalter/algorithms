package algorithms;


public interface MinPQ<E extends Comparable<? super E>>
{
    /**
     * Inserts an element into this minimum priority queue.
     *
     * @param elem the element to be inserted
     */
    void insert(E elem);

    /**
     * Returns the minimal element of this minimum priority queue.
     *
     * @return the minimal element of his minimum priority queue
     */
    E min();

    /**
     * Returns and removes the minimal element of this minimum priority queue.
     *
     * @return the minimal element of this minimum priority queue
     */
    E delMin();

    /**
     * Tests if this minimum priority queue is empty.
     *
     * @return {@code true} if this minimum priority queue is empty; {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this minimum priority queue.
     *
     * @return the number of elements in this minimum priority queue
     */
    int size();
}