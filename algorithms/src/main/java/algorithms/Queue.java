package algorithms;

/**
 * A {@code Queue} is a <em>first-in-first-out</em> collection. When iterating
 * through the {@code Queue}, the order of elements is kept.
 *
 * @param <E> the type of elements in the {@code Queue}
 *
 * @author DeepWalter
 */
public interface Queue<E> extends Iterable<E>
{
    /**
     * Add an element to the tail of this queue. After this operation,
     * the size of this queue increases by one.
     *
     * @param elem the element to be added
     */
    void enqueue(E elem);

    /**
     * Remove the element from the head of this queue and return that
     * element. After this operation, the size of this queue decreases by one.
     *
     * @return the element removed
     */
    E dequeue();

    /**
     * Test if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Get the size of this queue.
     *
     * @return the size of this queue
     */
    int size();
}