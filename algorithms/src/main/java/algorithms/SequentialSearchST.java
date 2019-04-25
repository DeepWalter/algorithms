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
    private Node head;
    private int N;      // size of this symbol table

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
    public int size() { return N; }

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
                if (iter.val != null && val == null) N--;   // lazy deletion
                if (iter.val == null && val != null) N++;   // insertion
                iter.val = val;
                return;
            }
        }

        // when key is absent
        if (val != null) {
            head = new Node(key, val, head);
            N++;
        }
    }

    @Override
    public Iterable<K> keys()
    {
        // return new Iterable<K>() {
        //     public Iterator<K> iterator()
        //     {
        //         return new Iterator<K>() {
        //             private Node iter = head;

        //             public boolean hasNext() { return iter != null; }

        //             public K next() throws NoSuchElementException
        //             {
        //                 if (!hasNext()) throw new NoSuchElementException();

        //                 K temp = iter.key;
        //                 iter = iter.next;

        //                 return temp;
        //             }
        //         };
        //     }
        // };
        return () -> new Iterator<K>() {
            private Node iter = head;

            @Override
            public boolean hasNext() { return iter != null; }

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
}