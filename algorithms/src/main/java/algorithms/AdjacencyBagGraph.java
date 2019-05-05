package algorithms;


/**
 * A adjacency bag implementation of the {@link Graph} interface.
 */
public class AdjacencyBagGraph implements Graph
{
    /** Number of vertices in this graph. */
    private final int vertexCount;
    /** Number of edges in this graph. */
    private int edgeCount;
    /** Adjacency bags. */
    private Bag<Integer>[] adjBags;

    /**
     * Initialize a graph with {@code v} vertices.
     * @param v number of total vertices
     */
    @SuppressWarnings("unchecked")
    public AdjacencyBagGraph(int v)
    {
        vertexCount = v;
        adjBags = new Bag[v];
        for (int i = 0; i < v; i++) {
            adjBags[i] = new LinkedListBag<>();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countVertices()
    {
        return vertexCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countEdges()
    {
        return edgeCount;
    }


}