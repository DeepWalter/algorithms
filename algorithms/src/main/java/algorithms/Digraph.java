package algorithms;


/**
 * A directed graph.
 */
public interface Digraph
{
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    int countVertices();

    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    int countEdges();

    /**
     * Adds an edge {@code v -> w} into this digraph.
     *
     * @param v head of the edge
     * @param w tail of the edge
     */
    void addEdge(int v, int w);

    /**
     * Returns an iterable object over all vertices connecting to {@code v} by edges pointing from
     * {@code v}.
     *
     * @param v the vertex to match
     * @return an iterable object over all vertices connecting to {@code v} by edges pointing from
     * {@code v}
     */
    Iterable<Integer> adjacentVerticesOf(int v);

    /**
     * Reverses this digraph.
     *
     * @return a copy of this digraph with each edge's direction reversed
     */
    Digraph reverse();
}