package algorithms;


/**
 * The {@code QuickFindUF} class is an implementation of the {@link UF}
 * interface with constant time operation {@link UF#find(int)} (hence the name
 * <em>quick find</em>).
 *
 * <p>
 * In accordance with the specification of {@link UF} interface, the set of
 * <em>n</em> objects are represented as integers from 1 to <em>n - 1</em> and
 * each component is identified by an integer between 1 and <em>n - 1</em>.
 * </p>
 *
 * <p>The implementation of {@code QuickFindUF} uses an {@code int} array to
 * store the <em>component identifier</em> of each object. The component
 * identifier of an object is the identifier of the component to which the
 * object belongs. Two objects are in the same component iff they have the same
 * component identifier. Initially, each object is in its own component. That
 * is, object <em>i</em> has a component identifier <em>i</em>. The
 * implementation also stores the number of components in an {@code int}
 * variable.
 * <ul>
 *   <li>{@code find(p)} returns the component identifier of {@code p}. Time
 * complexity: {@code O(1)}.</li>
 *   <li>{@code union(p, q)} changes those component identifiers which equal to
 * the component identifier of {@code p} into the component identifier of
 * {@code q} and then decreases the number of components by one. Time
 * complexity: {@code O(n)}.</li>
 * </ul>
 *
 * For more information, see Section 1.5 of <i>Algorithms, 4th Edition</i>.
 * </p>
 *
 * @author DeepWalter
 * @see UF
 */
public class QuickFindUF implements UF
{
    private int[] id;   // component identifier array
    private int count;   // number of components

    /**
     * Initialize an empty union-find data structure with {@code n} objects
     * indexed from {@code 0} to {@code n - 1}. Each object is initially in its
     * own component.
     *
     * @param n total number of objects
     */
    public QuickFindUF(int n)
    {
        if (n < 0) throw new IllegalArgumentException(
            "Total number of objects cannot be negative!");

        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() { return count; }

    /**
     * Find the component identifier of {@code p}. {@code p} should be in
     * range {@code [0, n - 1]}, here {@code n} is the total number of objects.
     *
     * @param p the integer index of an object
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    @Override
    public int find(int p) throws IllegalArgumentException
    {
        int n = id.length;
        if (p < 0 || p >= n) throw new IllegalArgumentException(
            "index" + p + "is not between 0 and " + (n - 1));

        return id[p];
    }

    /**
     * Add a connection between object {@code p} and object {@code q} if they
     * are not in the same component. {@code p} and {@code q} should be in
     * range {@code [0, n - 1]} where {@code n} is the total number of objects.
     *
     * @param p the integer index of one object
     * @param q the integer index of another object
     * @throws IllegalArgumentException unless {@code 0 <= p < n} and
     * {@code 0 <= q < n}
     */
    @Override
    public void union(int p, int q) throws IllegalArgumentException
    {
        int pId = find(p);
        int qId = find(q);

        if (pId != qId) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId) id[i] = qId;
            }
            count--;
        }
    }
}