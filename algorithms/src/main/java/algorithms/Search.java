package algorithms;


/**
 * An interface for graph searching. This interface provides two methods:
 * <ul>
 *   <li>{@link #marked()}: determine if the target vertex is reachable from the given source;</li>
 *   <li>{@link #count()}: count how many vertices are reachable from the given source.</li>
 * </ul>
 *
 * <p>
 * The source can be a single vertex or a collection of vertices. It should be specified at
 * initialization along with the graph.
 */
public interface Search
{
    /**
     * Tests if the target vertex {@code v} is reachable from the given source.
     *
     * @param v the target vertex
     * @return {@code true} if vertex {@code v} is reachable from the given source; {@code false}
     * otherwise
     */
    boolean marked(int v);

    /**
     * Returns the number of vertices which are reachable from the given source.
     *
     * @return the number of vertices which are reachable from the given source
     */
    int count();
}