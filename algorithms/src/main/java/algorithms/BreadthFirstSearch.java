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
     * Initializes the search process with the graph and the source.
     *
     * @param graph the graph to search
     * @param source the source vertex
     * @throws IllegalArgumentException if the vertex {@code source} is not in {@code graph}
     */
    public BreadthFirstSearch(Graph graph, int source)
    {
        vertexCount = graph.countVertices();
        Queue<Integer> queue = new LinkedListQueue<>();

        vertexCheck(source);
        marked[source] = true;
        count++;
        queue.enqueue(source);

        breadthFirstSearch(graph, queue);
    }

    /**
     * Initializes the search process with the graph and the sources.
     *
     * @param graph the graph to search
     * @param sources the source vertices
     * @throws IllegalArgumentException if any vertex in the {@code sources} is not in {@code graph}
     */
    public BreadthFirstSearch(Graph graph, Iterable<Integer> sources)
    {
        vertexCount = graph.countVertices();
        Queue<Integer> queue = new LinkedListQueue<>();

        for (int s: sources) {
            vertexCheck(s);
            if (!marked[s]) {   // allow duplicate sources
                marked[s] = true;
                count++;
                queue.enqueue(s);
            }
        }

        breadthFirstSearch(graph, queue);
    }

    /**
     * Initializes the search process with the graph and the sources.
     *
     * @param graph the graph to search
     * @param sources the source vertices
     * @throws IllegalArgumentException if any vertex in the {@code sources} is not in {@code graph}
     */
    public BreadthFirstSearch(Graph graph, int[] sources)
    {
        vertexCount = graph.countVertices();
        Queue<Integer> queue = new LinkedListQueue<>();

        for (int s: sources) {
            vertexCheck(s);
            if (!marked[s]) {   // allow duplicate sources
                marked[s] = true;
                count++;
                queue.enqueue(s);
            }
        }

        breadthFirstSearch(graph, queue);
    }


    /**
     *
     * @param graph the graph to search
     * @param queue a queue that stores most recently processed vertices
     */
    private void breadthFirstSearch(Graph graph, Queue<Integer> queue)
    {
        while (!queue.isEmpty()) {
            int s = queue.dequeue();
            for (int v: graph.adjacentVerticesOf(s)) {
                if (!marked[v]) {
                    marked[v] = true;
                    count++;
                    queue.enqueue(v);
                }
            }
        }
    }

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
     * {@inheritDoc}
     */
    @Override
    public int count()
    {
        return count;
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
