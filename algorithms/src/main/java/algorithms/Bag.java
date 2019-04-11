package algorithms;

/**
 * A
 * @param <E> Type of the element
 */
public interface Bag<E> extends Iterable<E>
{
    void add(E elem);
    boolean isEmpty();
    int size();
}
