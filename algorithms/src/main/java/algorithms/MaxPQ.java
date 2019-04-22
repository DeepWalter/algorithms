package algorithms;


public interface MaxPQ<E extends Comparable<? super E>>
{
    /**
     * Inserts an element into this maximum priority queue.
     *
     * @param elem the element to be inserted
     */
    void insert(E elem);

    /**
     * Returns the maximum element in this maximum priority queue.
     *
     * @return the maximum element in this maximum priority queue
     */
    E max();

    /**
     * Returns and removes the maximum element in this maximum priority queue.
     *
     * @return the maximum element in this maximum priority queue
     */
    E delMax();

    /**
     * Tests if this maximum priority queue is empty.
     *
     * @return {@code true} if this maximum priority queue is empty; {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this maximum priority queue.
     *
     * @return the number of elements in this maximum priority queue
     */
    int size();
}