package algorithms;


/**
 * An interface for graph searching. This interface provides two methods:
 * <ul>
 *   <li>{@link #marked()}: determine if a vertex is connected to the given source;</li>
 *   <li>{@link #count()}: count how many vertices are connected to the given source.</li>
 * </ul>
 *
 * <p>
 * The source can be a single vertex or a collection of vertices.
 */
public interface Search
{
    /**
     * Tests if vertex {@code v} is connected to the given source.
     *
     * @param v the vertex to test
     * @return {@code true} if {@code v} is connected to the given source; {@code false} otherwise
     */
    boolean marked(int v);

    /**
     * Returns the number of vertices connecting to the given source.
     *
     * @return the number of vertices connecting to the given source
     */
    int count();
}