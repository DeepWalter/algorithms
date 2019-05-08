package algorithms;


/**
 * An interface for finding connected components in <strong>undirected graph</strong>.
 */
public interface Components
{
    /**
     * Tests if the two given vertices {@code v} and {@code w} are connected, i.e. in the same
     * component.
     *
     * @param v vertex
     * @param w vertex
     * @return {@code true} if {@code v} and {@code w} are connected; {@code false} otherwise
     */
    default boolean connected(int v, int w)
    {
        return id(v) == id(w);
    }

    /**
     * Returns the number of connected components.
     *
     * @return the number of connected components
     */
    int count();

    /**
     * Returns the identifier of the component to which the vertex {@code v} belongs.
     *
     * @param v the vertex to match
     * @return the identifier of the component to which the vertex {@code v} belongs
     */
    int id(int v);
}