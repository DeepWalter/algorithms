package algorithms;


/**
 * An interface for path-finding in graphs.
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
}