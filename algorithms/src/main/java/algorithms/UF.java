package algorithms;


/**
 * The {@code UF} interface specifies the API of the <em>union-find data type
 * </em>. It supports the {@code union} and {@code find} operations, along with
 * a {@code connected} operation which determines whether two objects are in
 * the same component and a {@code size} operation which returns the number of
 * components.
 *
 * <p>
 * The union-find data type models connectivity among a set of <em>n</em>
 * objects. For simplicity, we represent each object as an integer in the
 * range [0, <em>n-1</em>].
 * The <em>is-connected-to</em> is an equivalence relation (denoted as ~)
 * between two objects, namely it is:
 * <ul>
 *   <li>Reflexive: for all object <em>p</em>, <em>p ~ p</em>.</li>
 *   <li>Symmetric: for all objects <em>p</em> and <em>q</em>, <em>p ~ q</em>
 * implies <em>q ~ p</em>.</li>
 *   <li>Transitive: for all objects <em>p</em>, <em>q</em>, and <em>r</em>,
 * <em>p ~ q</em> and <em>q ~ r</em> implies <em>p ~ r</em>.</li>
 * </ul>
 * The above equivalence relation partitions the set into equivalence classes.
 * Any two objects in the same equivalence class is connected. Hence an
 * equivalence class is also called a <em>connected component</em>, or simply
 * a <em>component</em>. Since there are at most <em>n</em> distinct components,
 * they can also be represented as integers from 0 to <em>n-1</em>.
 *
 */
public interface UF
{
    /**
     * Add a connection between object {@code p} and object {@code q} if they
     * are not in the same component.
     *
     * @param p the integer representing one object
     * @param q the integer representing another object
     */
    void union(int p, int q);

    /**
     * Find the component to which {@code p} belongs.
     * @param p the integer representing an object
     * @return an integer in [0, <em>n - 1</em>] representing the component
     * to which {@code p} belongs
     */
    int find(int p);

    /**
     * Test if object {@code p} and object {@code q} are in the same component.
     *
     * @param p the integer representing one object
     * @param q the integer representing another object
     * @return {@code true} if {@code p} and {@code q} are in the same
     * componet; {@code false} otherwise
     */
    default boolean connected(int p, int q) { return find(p) == find(q); }

    /**
     * Get the number of components.
     *
     * @return number of components
     */
    int count();
}