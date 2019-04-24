package algorithms;

/**
 * A {@code Bag} is a collection where removing elements are not supported. Its purpose is to
 * collect elements and then to iterate through them. The order of iteration is unspecified.
 *
 * @param <E> the type of elements in this {@code Bag}
 *
 * @author DeepWalter
 *
 * @see Stack
 * @see Queue
 */
public interface Bag<E> extends Iterable<E>
{
    /**
     * Adds an element into this bag. After this operation, the size of this bag increases by one.
     *
     * @param elem the element to be added
     */
    void add(E elem);

    /**
     * Tests if this bag is empty.
     *
     * @return {@code true} if this bag is empty; {@code false} otherwise
     */
    default boolean isEmpty() { return size() == 0; }

    /**
     * Returns the size of this bag.
     *
     * @return the size of this bag
     */
    int size();
}
