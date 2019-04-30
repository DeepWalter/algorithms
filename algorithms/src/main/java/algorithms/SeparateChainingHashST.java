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

    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % hashSize;
    }

}