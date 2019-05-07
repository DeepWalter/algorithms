package algorithms;


/**
 * A depth-first search implementation of the {@link Search} interface.
 */
public class DepthFirstSearch implements Search
{
    /** An array recording the info whether a vertex is visited. */
    private boolean[] marked;

    /** Number of vertices visited. */
    private int count;

    /** Number of vertices in the graph to be searched. */
    private final int vertexCount;

    /**
     * Initializes the search process with the graph and the given source.
     *
     * @param graph the graph to search
     * @param source the source
     * @throws IllegalArgumentException if the source vertex {@code s} is not in {@code graph}
     */
    public DepthFirstSearch(Graph graph, int source)
    {
        vertexCount = graph.countVertices();
        vertexCheck(source);
        marked = new boolean[vertexCount];

        depthFirstSearch(graph, source);
    }

    /**
     * Initializes the search process with the graph and the given source.
     *
     * @param graph the graph to search
     * @param sources the source
     * @throws IllegalArgumentException if any vertex in the {@code sources} is not in {@code graph}
     */
    public DepthFirstSearch(Graph graph, Iterable<Integer> sources)
    {
        vertexCount = graph.countVertices();
        for (int s: sources) {
            vertexCheck(s);
            if (!marked(s)) {
                depthFirstSearch(graph, s);
            }
        }
    }

    /**
     * Initializes the search process with the graph and the given source.
     *
     * @param graph the graph to search
     * @param sources the source
     * @throws IllegalArgumentException if any vertex in the {@code sources} is not in {@code graph}
     */
    public DepthFirstSearch(Graph graph, int[] sources)
    {
        vertexCount = graph.countVertices();
        for (int s: sources) {
            vertexCheck(s);
            if (!marked(s)) {
                depthFirstSearch(graph, s);
            }
        }
    }

    /* Depth-first search from the source s. */
    private void depthFirstSearch(Graph graph, int s)
    {
        marked[s] = true;
        count++;
        for (int v: graph.adjacentVerticesOf(s)) {  // s -> v when graph is directed
            if (!marked[v]) {
                depthFirstSearch(graph, v);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int count()
    {
        return count;
    }

    /**
     * {@inheritDoc}
     * @
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
