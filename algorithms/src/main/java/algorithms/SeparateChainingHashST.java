package algorithms;


/**
 * Separate chaining hash table implementation of the {@link ST} (symbol table) interface.
 *
 * @author DeepWalter
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 *
 * @see ST
 * @see SequentialSearchST
 */
public class SeparateChainingHashST<K extends Comparable<? super K>, V> implements ST<K, V>
{
    /** Symbol tables for storing key-value pairs. */
    private SequentialSearchST<K, V>[] sts;
    /** Hash table size. */
    private int hashSize;
    /** Symbol table size. */
    private int size;

    /** Default size of the hash table. */
    private static final int DEFAULT_CAPACITY = 997;

    /**
     * Creates a hash table with the default size {@code 997}.
     */
    public SeparateChainingHashST() { this(DEFAULT_CAPACITY); }

    /**
     * Creates a hash table of size {@code hashSize}.
     *
     * @param hashSize the size of the hash table
     */
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
     * Returns the hash value of {@code key}. This value should be in {@code [0, hashSize)}.
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
        int oldSizeOfi = sts[i].size();

        sts[i].put(key, val);
        size += (sts[i].size() - oldSizeOfi);
    }

    /**
     * {@inheritDoc}
     */
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