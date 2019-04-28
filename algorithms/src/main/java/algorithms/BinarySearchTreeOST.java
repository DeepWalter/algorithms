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
        private K key;
        private V val;
        private Node left;
        private Node right;
        private int N = 1;      // size of the subtree rooted at this node

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


}