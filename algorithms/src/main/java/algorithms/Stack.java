package algorithms;

/**
 * A (pushdown) {@code Stack} is a <em>last-in-first-out</em> collection. When
 * iterating through the {@code Stack}, the order of elements is reversed.
 *
 * @param <E> the type of elements in the {@code Stack}
 *
 * @author DeepWalter
 */
public interface Stack<E> extends Iterable<E>
{
    void push(E elem);
    E pop();
    boolean isEmpty();
    int size();
}