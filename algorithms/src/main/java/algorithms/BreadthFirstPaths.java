package algorithms;


/**
 * A breath-first search implementation of the {@link Paths} interface.
 */
public class BreadthFirstPaths implements Paths
{
    /** An array recording the info whether each vertex is visited. */
    private boolean[] marked;

    /** An array recording the last vertex on known path to this vertex. */
    private int[] edgeTo;

    /** The source vertex. */
    private final int source;

    /** Number of vertices in the graph to be searched. */
    private final int vertexCount;

    /**
     * Initializes the search process with the graph and the source vertex.
     *
     * @param graph the graph to search
     * @param s the source vertex
     * @throws IllegalArgumentException if the source vertex {@code s} is not in {@code graph}
     */
    public BreadthFirstPaths(Graph graph, int s)
    {
        vertexCount = graph.countVertices();
        vertexCheck(s);
        source = s;
        marked = new boolean[vertexCount];
        edgeTo = new int[vertexCount];

        marked[s] = true;
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(s);

        breadthFirstSearch(graph, queue);
    }

    private void breadthFirstSearch(Graph graph, Queue<Integer> queue)
    {
        while (!queue.isEmpty()) {
            int s = queue.dequeue();
            for (int v: graph.adjacentVerticesOf(s)) {
                if (!marked[v]) {
                    marked[v] = true;
                    edgeTo[v] = s;
                    queue.enqueue(v);
                }
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