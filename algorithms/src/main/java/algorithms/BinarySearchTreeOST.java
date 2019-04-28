package algorithms;


/**
 * Binary search tree implementation of {@link OST} ordered symbol table interface.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 *
 * @author DeepWalter
 *
 * @see OST
 */
public class BinarySearchTreeOST<K extends Comparable<? super K>, V> implements OST<K, V>
{
    private Node root;  // root of this binary search tree

    private class Node
    {
        K key;
        V val;
        Node left;
        Node right;
        int N = 1;      // size of the subtree rooted at this node

        public Node(K key, V val, int N)
        {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public int size() { return size(root); }

    /**
     * Returns the size of the subtree rooted at {@code node}.
     *
     * @param node the root of the subtree
     * @return the size of the subtree rooted at {@code node}
     */
    private int size(Node node)
    {
        if (node == null) return 0;

        return node.N;
    }

    @Override
    public K max()
    {
        if (root == null) return null;

        return max(root).key;
    }

    /**
     * Returns the node with the maximal key of the subtree rooted at {@code node}, or {@code null}
     * if this subtree is empty.
     *
     * @param node the root of the subtree
     * @return the node with the maximal key of the subtree rooted at {@code node}, or {@code null}
     * if this subtree is empty
     */
    private Node max(Node node)
    {
        if (node == null) return null;
        if (node.right == null) return node;

        return max(node.right);
    }

    @Override
    public K min()
    {
        if (root == null) return null;

        return min(root).key;
    }

    /**
     * Returns the node with the minimal key of the subtree rooted at {@code node}, or {@code null}
     * if this subtree is empty.
     *
     * @param node the root of the subtree
     * @return the node with the minimal key of the subtree rooted at {@code node}, or {@code null}
     * if this subtree is empty
     */
    private Node min(Node node)
    {
        if (node == null) return null;
        if (node.left == null) return node;

        return min(node.left);
    }

    /**
     * @param key the key to match
     */
    @Override
    public V get(K key)
    {
        return get(key, root);
    }

    /**
     * Returns the value paired with {@code key} in the subtree rooted at {@code node}, or
     * {@code null} if {@code key} is not found.
     *
     * @param key the key to match
     * @param node the root of the subtree
     * @return the value paired with {@code key} in the subtree rooted at {@code node}, or
     * {@code null} if {@code key} is not found
     */
    private V get(K key, Node node)
    {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(key, node.left);
        } else if (cmp > 0) {
            return get(key, node.right);
        } else {
            return node.val;
        }
    }

    /**
     * @param key the key to insert
     * @param val the value corresponding to the key
     */
    @Override
    public void put(K key, V val)
    {
        if (val == null) {
            root = delete(key, root);
        } else {
            root = put(key, val, root);
        }
    }

    /**
     * Inserts the key-value pair into the subtree rooted at {@code node}.
     *
     * @param key the key to insert
     * @param val the value to insert
     * @param node the root of the subtree
     * @return the root of the new subtree
     */
    private Node put(K key, V val, Node node)
    {
        if (node == null) return new Node(key, val, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(key, val, node.left);
        } else if (cmp > 0) {
            node.right = put(key, val, node.right);
        } else {
            node.val = val;
        }
        node.N = size(node.left) + size(node.right) + 1;

        return node;
    }

    @Override
    public void delMin() { root = delMin(root); }

    /**
     * Removes the smallest key and its value from the subtree rooted at {@code node}.
     *
     * @param node the root of the subtree
     * @return the root of the new subtree
     */
    private Node delMin(Node node)
    {
        if (node == null) return null;

        if (node.left == null) {
            node = node.right;
        } else {
            node.left = delMin(node.left);
            node.N = size(node.left) + size(node.right) + 1;
        }

        return node;
    }

    @Override
    public void delMax() { root = delMax(root); }

    /**
     * Removes the largest key and its value from the subtree rooted at {@code node}.
     *
     * @param node the root of the subtree
     * @return the root of the new subtree
     */
    private Node delMax(Node node)
    {
        if (node == null) return null;

        if (node.right == null) {
            node = node.left;
        } else {
            node.right = delMax(node.right);
            node.N = size(node.left) + size(node.right) + 1;
        }

        return node;
    }

    /**
     * @param key the key to delete
     */
    @Override
    public void delete(K key) { root = delete(key, root); }

    /**
     * Removes {@code key} and its value from the subtree rooted at {@code node}.
     *
     * @param key the key to delete
     * @param node the root of the subtree
     * @return the root of the new subtree
     */
    private Node delete(K key, Node node)
    {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(key, node.left);
        } else if (cmp > 0) {
            node.right = delete(key, node.right);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = min(node.right);
            successor.right = delMin(node.right);
            successor.left = node.left;
            node = successor;
        }
        node.N = size(node.left) + size(node.right) + 1;

        return node;
    }
}
