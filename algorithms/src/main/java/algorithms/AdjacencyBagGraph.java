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


    /**
     * {@inheritDoc}
     *
     * @param v vertex of the edge
     * @param w vertex of the edge
     * @throws IllegalArgumentException unless {@code 0 <= v < countVertices()} and
     * {@code 0 <= w < countVertices()}
     */
    @Override
    public void addEdge(int v, int w) throws IllegalArgumentException
    {
        vertexCheck(v);
        vertexCheck(w);

        adjBags[v].add(w);
        adjBags[w].add(v);
        edgeCount++;
    }

    /**
     * {@inheritDoc}
     *
     * @param v the vertex to match
     * @throws IllegalArgumentException unless {@code 0 <= v < countVertices()}
     */
    @Override
    public Iterable<Integer> adjacentVerticesOf(int v) throws IllegalArgumentException
    {
        vertexCheck(v);

        return adjBags[v];
    }

    /**
     * Checks if the given vertex is in this graph. If not, throws an appropriate runtime exception.
     * @param v the vertex to check
     * @throws IllegalArgumentException unless {@code 0 <= v < countVertices()}
     */
    private void vertexCheck(int v) throws IllegalArgumentException
    {
        if (v < 0 || v >= vertexCount) {
            throw new IllegalArgumentException(illegalVertexMsg(v));
        }
    }

    /**
     * Constructs an IllegalArgumentException detail message.
     *
     * @param v the vertex
     * @return a detail message
     */
    private String illegalVertexMsg(int v)
    {
        return "Vertex: " + v + ", not in the range [0, " + vertexCount + ").";
    }
}
