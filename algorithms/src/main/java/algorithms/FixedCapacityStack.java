package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<E> implements Stack<E>
{
    private E[] a ;  // stack entries
    private int N = 0;  // size

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int capacity)
    {
        a = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() { return N == 0; }

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

            public E next()
            {
                if (!hasNext()) throw new NoSuchElementException();
                return a[--id];
            }
        };
    }

}