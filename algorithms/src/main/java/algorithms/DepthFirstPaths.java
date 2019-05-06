package algorithms;


/**
 * A depth-first search implementation of the {@link Paths} interface.
 */
public class DepthFirstPaths implements Paths
{
    /** An array recording the info whether a vertex is visited. */
    private boolean[] marked;

    /** An array recording the last vertex on known path to this vertex. */
    private int[] edgeTo;

    /** The source vertex. */
    private final int source;

    /** Number of vertices in the graph to be searched. */
    private final int vertexCount;

    /**
     * Initializes the search process with the graph and the given source.
     *
     * @param graph the graph to search
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph graph, int s)
    {
        vertexCount = graph.countVertices();
        vertexCheck(s);
        source = s;

        depthFirstSearch(graph, source);
    }

    private void depthFirstSearch(Graph graph, int v)
    {
        marked[v] = true;
        for (int w: graph.adjacentVerticesOf(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                depthFirstSearch(graph, w);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param v the target vertex
     * @throws IllegalArgumentException if vertex {@code v} is not in the graph
     */
    @Override
    public boolean hasPathTo(int v)
    {
        vertexCheck(v);

        return marked[v];
    }

    /**
     * {@inheritDoc}
     *
     * @param v the target vertex
     * @throws IllegalArgumentException if vertex {@code v} is not in the graph
     */
    @Override
    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stack = new LinkedListStack<>();
        for (int w = v; w != source; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(source);

        return stack;
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
