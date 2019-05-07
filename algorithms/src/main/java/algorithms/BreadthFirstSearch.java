package algorithms;


/**
 * A breadth-first search implementation of the {@link Search} interface.
 */
public class BreadthFirstSearch implements Search
{
    /** An array recording the info whether each vertex is visited. */
    private boolean[] marked;

    /** Number of vertices visited. */
    private int count;

    /** Number of vertices in the graph to be searched. */
    private final int vertexCount;

    /**
     * {@inheritDoc}
     *
     * @param v the target vertex
     * @throws IllegalArgumentException if vertex {@code v} is not in the graph to be searched
     */
    @Override
    public boolean marked(int v)
    {
    vertexCheck(v);

    return marked[v];
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