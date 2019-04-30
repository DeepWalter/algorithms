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

    /**
     * {@inheritDoc}
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * {@inheritDoc}
     *
     * @param key the key to match
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public V get(K key) throws IllegalArgumentException
    {
        if (key == null) {
            throw new IllegalArgumentException("Argument to get() is null!");
        }

        for (Node iter = head; iter != null; iter = iter.next) {
            if (iter.key.equals(key)) {
                return iter.val;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V val) throws IllegalArgumentException
    {
        if (key == null) {
            throw new IllegalArgumentException("First argument to put() is null!");
        }

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

    /**
     * Removes {@code key} and its value from the symbol table.
     *
     * <p>
     * <strong>Implementation Note:</strong> <br>
     * In this singly-linked list implementation of symbol table, the delete method is
     * implemented as eager deletion. This overrides the default {@link ST#delete} method.
     *
     * @param key the key to delete
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public void delete(K key) throws IllegalArgumentException
    {
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() is null!");
        }

        /* If we want to delete a node, we need access to the reference that points to it. That is,
         * we need to find its parent node if the node to be deleted is not the first one. Instead
         * of treating the first node as a special case, we create a phony parent node for it. This
         * trick gives every node in the symbol table a parent node. Hence we can iterate through
         * those parent nodes to find the one whose child has the desired key. If we find one, we
         * delete its child; otherwise, nothing needs to be done. At last, don't forget that the new
         * symbol table begins with the phony parent's child.
         */
        Node parent = new Node(null, null, head);   // the phony parent for the first node
        for (Node iter = parent; iter.next != null; iter = iter.next) {
            if (key.equals(iter.next.key)) {
                iter.next = iter.next.next;
                size--;
                break;
            }
        }
        head = parent.next;
    }
}