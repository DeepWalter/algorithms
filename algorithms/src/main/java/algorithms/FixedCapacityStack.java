package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * The {@code FixedCapacityStack} class is an implementation of the
 * {@link Stack} interface using an (fixed size) array.
 *
 * @param <E> the type of elements in the {@code FixedCapacityStack}
 */
public class FixedCapacityStack<E> implements Stack<E>
{
    private E[] a ;     // stack entries
    private int N = 0;  // size

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int capacity) throws IllegalArgumentException
    {
        if (capacity <= 0) throw new IllegalArgumentException(
            "Capacity must be positive: " + capacity);
        a = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() { return N == 0; }

    /**
     * Test whether this {@code FixedCapacityStack} has reached its maximal
     * capacity.
     *
     * @return {@code true} if this {@code FixedCapacityStack} reached its
     * maximal capacity; {@code false} otherwise
     */
    public boolean isFull() { return N == a.length; }

    @Override
    public int size() { return N; }

    @Override
    public void push(E elem)
    {
        a[N++] = elem;
    }

    @Override
    public E pop()
    {
        return a[--N];
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>()
        {
            private int id = N;

            public boolean hasNext() { return id != 0; }

            public E next() throws NoSuchElementException
            {
                if (!hasNext()) throw new NoSuchElementException();
                return a[--id];
            }
        };
    }
}
