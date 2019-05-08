package algorithms;


public class DepthFirstComponents implements Components
{
    /** An array recording the info whether each vertex is visited. */
    private boolean[] marked;

    /** Identifier of each vertex. */
    private int[] ids;

    /** Currently availabel identifier (starting with 0). */
    private int id = 0;

    /** Number of vertices in the graph to be searched. */
    private final int vertexCount;


    public DepthFirstComponents(Graph graph)
    {
        vertexCount = graph.countVertices();
        marked = new boolean[vertexCount];
        ids = new int[vertexCount];

        for (int v = 0; v < vertexCount; v++) {
            if (!marked[v]) {
                depthFirstSearch(graph, v, id++);
            }
        }
    }

    /* Find all vertices that are reachable from v and label them as id. */
    private void depthFirstSearch(Graph graph, int v, int id)
    {
        marked[v] = true;
        ids[v] = id;

        for (int w: graph.adjacentVerticesOf(v)) {
            if (!marked[w]) {
                depthFirstSearch(graph, w, id);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if the vertex {@code v} or {@code w} is not in the graph
     */
    @Override
    public boolean connected(int v, int w)
    {
        vertexCheck(v);
        vertexCheck(w);

        return ids[v] == ids[w];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int id(int v)
    {
        vertexCheck(v);

        return ids[v];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int count()
    {
        return id;
    }

    /**
     * Checks if the given vertex is in this digraph. If not, throws an appropriate runtime
     * exception.
     *
     * @param v the vertex to check
     * @throws IllegalArgumentException if vertex {@code v} is not in the graph
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