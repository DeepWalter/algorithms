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
    /**
     * Push an element onto the top of this stack. After this
     * operation, the size of this stack increases by one.
     *
     * @param elem the element to be pushed
     */
    void push(E elem);

    /**
     * Remove the element on the top of this stack and return that
     * element. After this operation, the size of this stack decreases by one.
     *
     * @return the element on the top of the stack
     */
    E pop();

    /**
     * Test if this stack is empty.
     *
     * @return {@code true} if this stack is empty; {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Get the size of this stack.
     *
     * @return the size of this stack
     */
    int size();
}