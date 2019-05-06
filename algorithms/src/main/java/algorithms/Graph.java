package algorithms;


/**
 * An undirected graph.
 */
public interface Graph
{
    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    int countVertices();

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    int countEdges();

    /**
     * Adds an edge {@code v - w} into this graph.
     *
     * @param v vertex of the edge
     * @param w vertex of the edge
     */
    void addEdge(int v, int w);

    /**
     * Returns an iterable object over all vertices connecting to {@code v}.
     *
     * @param v the vertex to match
     * @return an iterable object over all vertices connecting to {@code v}
     */
    Iterable<Integer> adjacentVerticesOf(int v);
}