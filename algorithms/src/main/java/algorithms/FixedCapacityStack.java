package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * The {@code FixedCapacityStack} class is an implementation of the {@link Stack} interface using an
 * (fixed size) array.
 *
 * @param <E> the type of elements in this {@code FixedCapacityStack}
 */
public class FixedCapacityStack<E> implements Stack<E>
{
    private E[] a ;     // stack entries
    private int N = 0;  // size

    /**
     * Initializes a {@code FixedCapacityStack} with the given capacity.
     *
     * @param capacity capacity of this {@code FixedCapacityStack}
     * @throws IllegalArgumentException if {@code capacity <= 0}
     */
    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int capacity)
    {
        if (capacity <= 0) throw new IllegalArgumentException(
            "Capacity must be positive: " + capacity);
        a = (E[]) new Object[capacity];
    }

    /**
     * Tests whether this {@code FixedCapacityStack} has reached its maximal capacity.
     *
     * @return {@code true} if this {@code FixedCapacityStack} reached its maximal capacity;
     * {@code false} otherwise
     */
    public boolean isFull() { return N == a.length; }

    @Override
    public int size() { return N; }

    @Override
    public void push(E elem)
    {
        a[N++] = elem;
    }

    /**
     * {@inheritDoc}
     *
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public E pop()
    {
        if (isEmpty()) throw new NoSuchElementException("Can not pop an empty stack!");

        return a[--N];
    }

    /**
     * Returns an iterator over elements of this {@code FixedCapacityStack}.
     *
     * @return an {@code Iterator}
     */
    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
            private int id = N;

            public boolean hasNext() { return id != 0; }

            public E next()
            {
                if (!hasNext()) throw new NoSuchElementException();
                return a[--id];
            }
        };
    }
}
