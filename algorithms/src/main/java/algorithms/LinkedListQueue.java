package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * {@code LinkedListQueue} is an implementation of the <em>FIFO</em>
 * {@link Queue} via singly linked list.
 *
 * @param <E> the type of elements in {@code LinkedListQueue}
 */
public class LinkedListQueue<E> implements Queue<E>
{
    private Node head;
    private Node tail;
    private int N;

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
    public E dequeue() throws NoSuchElementException
    {
        if(isEmpty()) throw new NoSuchElementException();

        E elem = head.elem;
        head = head.next;
        N--;
        if (isEmpty()) tail = null;

        return elem;
    }

    @Override
    public void enqueue(E elem)
    {
        Node newTail = new Node();
        newTail.elem = elem;

        if (isEmpty()) {
            head = newTail;
            tail = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        N++;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E> ()
        {
            private Node iter = head;

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