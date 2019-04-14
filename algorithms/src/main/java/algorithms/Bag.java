package algorithms;

/**
 * A {@code Bag} is a collection where removing elements are not supported. Its
 * purpose is to collect elements and then to iterate through them. The order
 * of iteration is unspecified.
 *
 * @param <E> the type of elements in the {@code Bag}
 *
 * @author DeepWalter
 */
public interface Bag<E> extends Iterable<E>
{
    /**
     * Add an element into this bag. After this operation, the size of
     * this bag increases by one.
     *
     * @param elem the element to be added
     */
    void add(E elem);

    /**
     * Test if this bag is empty.
     *
     * @return {@code true} if this bag is empty; {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Get the size of this bag.
     *
     * @return the size of this bag
     */
    int size();
}
