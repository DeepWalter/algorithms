package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * {@code LinkedListStack} is the implementation of a pushdown {@code Stack}
 * via a linked list.
 *
 * @param <E> the type of elements in {@code LinkedListStack}
 *
 * @author DeepWalter
 */
public class LinkedListStack<E> implements Stack<E>
{
    private Node top;   // top of stack
    private int N;      // size of stack

    private class Node
    {
        E elem;
        Node next;
    }

    @Override
    public boolean isEmpty() { return N == 0; }

    @Override
    public int size() { return N; }

    @Override
    public E pop()
    {
        if (isEmpty()) throw new NoSuchElementException(
            "Can not pop: Stack is empty!");

        E elem = top.elem;
        top = top.next;
        N--;

        return elem;
    }

    @Override
    public void push(E elem)
    {
        Node newTop = new Node();
        newTop.elem = elem;
        newTop.next = top;

        top = newTop;
        N++;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E> ()
        {
            private Node iter = top;

            public boolean hasNext() { return iter != null; }

            public E next() throws NoSuchElementException
            {
                if (!hasNext()) throw new NoSuchElementException();

                E elem = iter.elem;
                iter = iter.next;

                return elem;
            }
        };
    }
}