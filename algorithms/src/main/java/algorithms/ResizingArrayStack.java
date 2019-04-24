package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code ResizingArrayStack} class is an implementation of the
 * {@link Stack} interface that resizes the array.
 *
 * <p>
 * The array is dynamically resized such that it is sufficiently large to hold
 * all of the items and not so large as to waste an excessive amount of space:
 * <ul>
 *   <li>when there is no room for new elements, we <em>double</em> the size of
 * the array.</li>
 *   <li>when the stack size is less than <em>a quarter</em> of the capacity,
 * we <em>half</em> the size of the array.
 * </ul>
 * With this implementation the {@code ResizingArrayStack} never overflows and
 * never becomes less than a-quarter full.
 * </p>
 *
 * @param <E> the type of elements in this {@code ResizingArrayStack}
 *
 * @author DeepWalter
 *
 * @see Stack
 * @see FixedCapacityStack
 */
public class ResizingArrayStack<E> implements Stack<E>
{
    private E[] array;  // stack entries
    private int N = 0;  // size

    /**
     * Initialize this stack with capacity one.
     */
    @SuppressWarnings("unchecked")
    public ResizingArrayStack()
    {
        array = (E[]) new Object[1];
    }

    /**
     * Initialize this stack with the given capacity.
     *
     * @param capacity initial capacity of the array
     */
    @SuppressWarnings("unchecked")
    public ResizingArrayStack(int capacity) throws IllegalArgumentException
    {
        if (capacity <= 0) throw new IllegalArgumentException(
            "Capacity must be positive: " + capacity);
        array = (E[]) new Object[capacity];
    }

    @Override
    public int size() { return N; }

    /**
     * @param elem the element to be pushed
     */
    @Override
    public void push(E elem)
    {
        if (array.length == N) resize(2 * N);
        array[N++] = elem;
    }

    @Override
    public E pop() throws NoSuchElementException
    {
        if (N == 0) throw new NoSuchElementException(
            "Can not pop an empty ResizingArrayStack!");

        E elem = array[--N];
        array[N] = null;    // avoid loitering
        if (N > 0 && N <= array.length/4) resize(array.length/2);

        return elem;
    }

    /**
     * Resize the array into the given capacity.
     *
     * @param capacity length of the target array
     */
    private void resize(int capacity) throws IllegalArgumentException
    {
        if (capacity <= 0) throw new IllegalArgumentException(
            "Capacity must be positive:" + capacity);

        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
            private int id = N;

            public boolean hasNext() { return id > 0; }

            public E next() throws NoSuchElementException
            {
                if (!hasNext()) throw new NoSuchElementException();

                return array[--id];
            }
        };
    }
}
