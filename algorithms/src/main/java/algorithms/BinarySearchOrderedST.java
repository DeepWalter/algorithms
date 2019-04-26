package algorithms;

import java.util.NoSuchElementException;

/**
 * Array implementation of {@link OrderedST} (ordered symbol table) interface.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class BinarySearchOrderedST<K extends Comparable<? super K>, V> implements OrderedST<K, V>
{
    private K[] keys;
    private V[] vals;
    private int N;      // size

    @Override
    public int size() { return N; }

    @Override
    public K min()
    {
        if (isEmpty()) return null;

        return keys[0];
    }

    @Override
    public K max()
    {
        if (isEmpty()) return null;

        return keys[keys.length - 1];
    }

    /**
     * @param key the key to match
     */
    @Override
    public int rank(K key)
    {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                hi = mid - 1;
            } else if (key.compareTo(keys[mid]) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * @param k the rank
     *
     * @throws NoSuchElementException unless {@code 0 <= k < N}
     */
    @Override
    public K select(int i) throws NoSuchElementException
    {
        if (i < 0 || i >= N) throw new NoSuchElementException();

        return keys[i];
    }

    /**
     * @param key the key to match
     */
    @Override
    public K ceiling(K key)
    {
        if (isEmpty() || key.compareTo(max()) > 0) return null;

        return keys[rank(key)];
    }

    @Override
    public K floor(K key)
    {
        if (isEmpty() || key.compareTo(min()) < 0) return null;

        int i = rank(key);
        if (key.compareTo(keys[i]) == 0) {
            return key;
        } else {
            return keys[i - 1];
        }

    }

    @Override
    public V get(K  key)
    {
        if (isEmpty()) return null; // sanity check

        int k = rank(key);
        if (k < N && keys[k].compareTo(key) == 0) {
            return vals[k];
        } else {
            return null;
        }
    }

    @Override
    public void put(K key, V val)
    {
        // if (contains(key)) {    // override the old value
        //     vals[rank(key)] = val;   // Cons: call rank twice
        // } else {                // insert a new key-value pair
        //     int i = N++;
        //     while (i > 0 && keys[i-1].compareTo(key) > 0) {
        //         keys[i] = keys[i - 1];
        //         vals[i] = vals[i - 1];
        //         i--;
        //     }
        //     keys[i] = key;
        //     vals[i] = val;
        // }

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) { // override if key already exists
            vals[i] = val;
        } else {    // if key is absent
            for (int j = N; j > i; j--) {   // Move those keys that are greater than key to the
                keys[j] = keys[j - 1];      // right by one position.
                vals[j] = vals[j - 1];
            }

            // Insert (key, val) and increase the size by one.
            keys[i] = key;
            vals[i] = val;
            N++;
        }
    }

    @Override
    public void delete(K key)
    {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            keys[N - 1] = null; // avoid loitering
            vals[N - 1] = null;
            N--;
        }
    }

    @Override
    public Iterable<K> keys(K low, K high)
    {
        Queue<K> q = new LinkedListQueue<>();
        for (int i = rank(low); i < rank(high); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(high)) q.enqueue(keys[rank(high)]);

        return q;
    }
}