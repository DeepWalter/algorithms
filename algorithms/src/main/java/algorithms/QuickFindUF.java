package algorithms;


/**
 * The {@code QuickFindUF} class is an implementation of the {@link UF}
 * interface with constant time operation {@link UF#find(int)} (hence the name
 * quick find).
 */
public class QuickFindUF implements UF
{
    private int[] id;   // component id array
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