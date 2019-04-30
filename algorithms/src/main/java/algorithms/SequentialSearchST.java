package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked-list implementation of the {@link ST} (symbol table) interface.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class SequentialSearchST<K, V> implements ST<K, V>
{
    /** Reference to the head node of this symbol table. */
    private Node head;
    /** Size of this symbol table. */
    private int size;

    private class Node
    {
        K key;
        V val;
        Node next;

        public Node(K key, V val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    @Override
    public int size() { return size; }

    /**
     * @param key the key to match
     */
    @Override
    public V get(K key)
    {
        for (Node iter = head; iter != null; iter = iter.next) {
            if (iter.key.equals(key)) {
                return iter.val;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V val)
    {
        for (Node iter = head; iter != null; iter = iter.next) {
            if (iter.key.equals(key)) {
                if (iter.val != null && val == null) size--;   // lazy deletion
                if (iter.val == null && val != null) size++;   // insertion
                iter.val = val;
                return;
            }
        }

        // when key is absent
        if (val != null) {
            head = new Node(key, val, head);
            size++;
        }
    }

    @Override
    public Iterable<K> keys()
    {
        return () -> new Iterator<K>() {
            private Node iter = head;

            @Override
            public boolean hasNext()
            {
                // Point iter to an existing key if there is any.
                while (iter != null && iter.val == null) iter = iter.next;

                return iter != null;
            }

            @Override
            public K next() throws NoSuchElementException
            {
                if (!hasNext()) throw new NoSuchElementException();

                K temp = iter.key;
                iter = iter.next;

                return temp;
            }
        };
    }

    // TODO: implement an eager deletion.
}