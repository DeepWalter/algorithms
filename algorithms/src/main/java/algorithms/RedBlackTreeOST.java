package algorithms;

import java.util.NoSuchElementException;


public class RedBlackTreeOST<K extends Comparable<? super K>, V> implements OST<K, V>
{
    private Node root;

    enum Color {RED, BLACK};

    private class Node
    {
        K key;
        V value;
        Node left;
        Node right;
        /** Size of the subtree rooted at this node. */
        int size;
        /** RED or BLACK. */
        Color color;

        public Node(K key, V value, int size, Color color)
        {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    private boolean isRed(Node node)
    {
        if (node == null) {
            return false;
        }

        return node.color == Color.RED;
    }

    /**
     * {inheritDoc}
     */
    @Override
    public int size()
    {
        return size(root);
    }

    /**
     * Returns the size of the subtree rooted at {@code node}.
     *
     * @param node the root of the subtree
     * @return the size of the subtree rooted at {@code node}
     */
    private int size(Node node)
    {
        if (node == null) {
            return 0;
        }

        return node.size;
    }

    /**
     * Rotates the right-lean red link pointing from {@code node} to left.
     *
     * @param node the node from which a right-lean red link points
     * @return the root of the resulting subtree
     */
    private Node rotateLeft(Node node)
    {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = Color.RED;
        temp.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);

        return temp;
    }

    /**
     * Rotates the left-lean red link pointing from {@code node} to right.
     *
     * @param node the node from which a left-lean red link points
     * @return the root of the resulting subtree
     */
    private Node rotateRight(Node node)
    {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = Color.RED;
        temp.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);

        return temp;
    }

    /**
     * Flips the color of {@code node} who has two red children.
     *
     * @param node the parent node who has two red children
     */
    private void flipColors(Node node)
    {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    /**
     * {@inheritDoc}
     * @param key the key to insert
     * @param value the value corresponding to the key
     */
    @Override
    public void put(K key, V value)
    {
        root = put(key, value, root);
        root.color = Color.BLACK;
    }

    /**
     * Puts key-value pair into the subtree rooted at {@code node}.
     *
     * @param key the key to insert
     * @param value the value corresponding to the key
     * @param node the root of the subtree
     * @return the root of the new subtree
     */
    private Node put(K key, V value, Node node)
    {
        if (node == null) {
            return new Node(key, value, 1, Color.RED);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(key, value, node.left);
        } else if (cmp > 0) {
            node.right = put(key, value, node.right);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.size = 1 + size(node.left) + size(node.right);

        return node;
    }

    @Override
    public V get(K key)
    {
        return get(key, root);
    }

    private V get(K key, Node node)
    {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(key, node.left);
        } else if (cmp > 0) {
            return get(key, node.right);
        } else {
            return node.value;
        }
    }

    // TODO: delete

    /**
     * {@inheritDoc}
     *
     * @param key the key to match
     */
    @Override
    public int rank(K key)
    {
        return rank(key, root);
    }

    /**
     * Returns the number of keys less than {@code key} in the subtree rooted at {@code node}.
     *
     * @param key the key to match
     * @param node the root of the subtree
     * @return the number of keys less than {@code key} in the subtree rooted at {@code node}
     */
    private int rank(K key, Node node)
    {
        if (node == null) return 0;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(key, node.left);
        } else if (cmp > 0) {
            return size(node.left) + 1 + rank(key, node.right);
        } else {
            return size(node.left);
        }
    }

    @Override
    public K select(int i) { return select(i, root); }

    /**
     * Returns the key with rank {@code i} in the subtree rooted at {@code node}.
     *
     * @param i the rank
     * @param node the root of the subtree
     * @return the key with rank {@code i} in the subtree rooted at {@code node}
     * @throws NoSuchElementException unless {@code 0 <= i < size(node)}
     */
    private K select(int i, Node node)
    {
        // if subtree is empty or i is out of range
        if (i < 0 || i >= size(node)) throw new NoSuchElementException();

        int s = size(node.left);
        if (i == s) {
            return node.key;
        } else if (i < s) {
            return select(i, node.left);
        } else {
            return select(i - s - 1, node.right);
        }
    }
}
