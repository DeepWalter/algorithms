package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly-linked list implementation of the {@link ST} (symbol table) interface.
 *
 * @author DeepWalter
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 *
 * @see SeparateChainingHashST
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
    public V get(K key)
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

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @Override
    public void put(K key, V val)
    {
        if (key == null) {
            throw new IllegalArgumentException("First argument to put() is null!");
        }

        if (val == null) {
            delete(key);
            return;
        }

        for (Node iter = head; iter != null; iter = iter.next) {
            if (key.equals(iter.key)) {     // when key is found
                iter.val = val;             // overrides the value
                return;
            }
        }
        // when key is absent
        head = new Node(key, val, head);    // inserts key-val pair at head
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<K> keys()
    {
        return () -> new Iterator<K>() {
            private Node iter = head;

            @Override
            public boolean hasNext()
            {
                return iter != null;
            }

            @Override
            public K next()
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
    public void delete(K key)
    {
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() is null!");
        }

        /*
         * If we want to delete a node, we need access to the reference that points to it. That is,
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

    /**
     * Returns a Python dict-like string representation of this symbol table.
     *
     * @return a Python dict-like string representation of this symbol table
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("{");

        for (Node iter = head; iter != null; iter = iter.next) {
            str.append(" ");
            str.append(iter.key);
            str.append(": ");
            str.append(iter.val);
            str.append(",");
        }
        // remove the last comma if there is one
        int n = str.length();
        if (n > 1) {
            str.deleteCharAt(n-1);
        }

        str.append(" }");

        return str.toString();
    }
}
