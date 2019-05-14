package algorithms;


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
}
