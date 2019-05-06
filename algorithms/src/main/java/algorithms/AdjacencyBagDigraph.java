package algorithms;


/**
 * An adjacency bag implementation of the {@link Digraph} interface.
 */
public class AdjacencyBagDigraph implements Digraph
{
    /** Number of vertices in this digraph. */
    private final int vertexCount;

    /** Number of edges in this digraph. */
    private int edgeCount;

    /** Adjacency bags. */
    private Bag<Integer>[] adjBags;

    /**
     * Initializes a digraph with {@code n} vertices.
     *
     * @param n number of vertices
     * @throws IllegalArgumentException if {@code n < 0}
     */
    @SuppressWarnings("unchecked")
    public AdjacencyBagDigraph(int n)
    {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal number of vertices: " + n);
        }
        vertexCount = n;
        adjBags = new Bag[n];
        for (int i = 0; i < n; i++){
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
     * @param v head of the edge
     * @param w tail of the edge
     * @throws IllegalArgumentException unless {@code 0 <= v, w < countVertices()}
     */
    @Override
    public void addEdge(int v, int w)
    {
        vertexCheck(v);
        vertexCheck(w);

        adjBags[v].add(w);
        edgeCount++;
    }

    /**
     * Checks if the given vertex is in this digraph. If not, throws an appropriate runtime
     * exception.
     *
     * @param v the vertex to check
     * @throws IllegalArgumentException unless {@code 0 <= v < countVertices()}
     */
    private void vertexCheck(int v)
    {
        if (v < 0 || v >= vertexCount) {
            throw new IllegalArgumentException(illegalVertexMsg(v));
        }
    }

    /**
     * Constructs an IllegalArgumentException detail message.
     *
     * @param v a vertex
     * @return a detail message w.r.t. the vertex
     */
    private String illegalVertexMsg(int v)
    {
        return "Vertex: " + v + ", not in the range [0, " + vertexCount + ").";
    }
}