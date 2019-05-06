package algorithms;


/**
 * An interface for path-finding in graphs. This interface provides two methods:
 * <ol>
 *   <li>{@link #hasPathTo()}: determine if there is path from the given source to the target
 * vertex;</li>
 *   <li>{@link #pathTo()}: find such a path.</li>
 * </ol>
 *
 * <p>
 * The source is a single vertex which should be specified at initialization along with the graph.
 */
public interface Paths
{
    /**
     * Tests if there is a path from the given source to the target vertex {@code v}.
     *
     * @param v the target vertex
     * @return {@code true} if there is a path from the given source to the target vertex {@code v};
     * {@code false} otherwise
     */
    boolean hasPathTo(int v);

    /**
     * Returns a path from the given source to the target vertex {@code v}, or {@code null} if there
     * is none.
     *
     * @param v the target vertex
     * @return a path from the given source to the target vertex {@code v}, or {@code null} if there
     * is none
     */
    Iterable<Integer> pathTo(int v);
}