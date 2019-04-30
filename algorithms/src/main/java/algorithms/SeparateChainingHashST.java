package algorithms;


/**
 * Separate chaining hash table implementation of the {@link ST} (symbol table) interface.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class SeparateChainingHashST<K extends Comparable<? super K>, V> implements ST<K, V>
{
    /** Symbol tables for storing key-value pairs. */
    private SequentialSearchST<K, V>[] sts;
    /** Hash table size. */
    private int hashSize;
    /** Symbol table size. */
    private int size;

    /**
     * The default hash table size is set to {@code 997}.
     */
    public SeparateChainingHashST() { this(997); }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int hashSize)
    {
        sts = (SequentialSearchST<K, V>[]) new SequentialSearchST[hashSize];

        for (int i = 0; i < hashSize; i++) {
            sts[i] = new SequentialSearchST<>();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() { return size; }

    /**
     * {@inheritDoc}
     *
     * @param key the key to match
     */
    @Override
    public V get(K key)
    {
        int i = hash(key);
        return sts[i].get(key);
    }

    /**
     * Returns the hash value of {@code key}.
     *
     * @param key the key to hash
     * @return the hash value of {@code key}
     */
    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % hashSize;
    }

    /**
     * {@inheritDoc}
     *
     * @param key the key to insert
     * @param val the value corresponding to the key
     */
    @Override
    public void put(K key, V val)
    {
        int i = hash(key);
        int oldSize = sts[i].size();
        sts[i].put(key, val);
        size += (sts[i].size() - oldSize);
    }

    @Override
    public Iterable<K> keys()
    {
        Queue<K> queue = new LinkedListQueue<>();
        for (int i = 0; i < hashSize; i++) {
            for (K key: sts[i].keys()) {
                queue.enqueue(key);
            }
        }

        return queue;
    }
}