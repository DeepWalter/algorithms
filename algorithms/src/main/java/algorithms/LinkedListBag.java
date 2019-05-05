package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list implementation of the {@link Bag} interface.
 *
 * @param <E> the type of elements in this bag
 */
public class LinkedListBag<E> implements Bag<E>
{
    /** Head of the linked list. */
    private Node head;
    /** Size of this linked-list bag. */
    private int size;

    private class Node
    {
        E elem;
        Node next;

        public Node(E elem, Node next)
        {
            this.elem = elem;
            this.next = next;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Adds {@code elem} into this bag.
     *
     * @param elem the element to add
     */
    @Override
    public void add(E elem)
    {
        head = new Node(elem, head);
        size++;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>() {
            private Node iter = head;

            @Override
            public boolean hasNext()
            {
                return iter != null;
            }

            @Override
            public E next() throws NoSuchElementException
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E temp = iter.elem;
                iter = iter.next;

                return temp;
            }
        };
    }
}
