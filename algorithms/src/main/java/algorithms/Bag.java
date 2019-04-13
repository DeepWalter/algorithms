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
    void add(E elem);
    boolean isEmpty();
    int size();
}
