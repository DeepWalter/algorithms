package algorithms;

/**
 *
 * @param <E>
 */
public interface Stack<E> extends Iterable<E>
{
    void push(E elem);
    E pop();
    boolean isEmpty();
    int size();
}