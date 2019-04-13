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
    void enqueue(E elem);
    E dequeue();
    boolean isEmpty();
    int size();
}