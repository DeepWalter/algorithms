package algorithms;


/**
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface ST<K, V>
{
    /**
     * Puts key-value pair into this symbol table, or removes {@code key} if {@code val} is
     * {@code null}.
     *
     * @param key the key to put
     * @param val the value corresponding to the key
     */
    void put(K key, V val);

    /**
     * Returns the value paired with {@code key}, or {@code null} if {@code key} is not found.
     *
     * @param key the key to match
     * @return the value paired with {@code key}, or {@code null} if {@code key} is not found
     */
    V get(K key);

    /**
     * Removes {@code key} and its value from this symbol table. Default to the lazy deletion: just
     * set the value associated with key to {@code null}.
     *
     * @param key the key to remove
     */
    default  void delete(K key) { put(key, null); }

    /**
     * Tests if there is a value paired with {@code key}.
     *
     * @param key the key to match
     * @return {@code true} if there is a value paired with {@code key}; {@code false} otherwise
     */
    default boolean contains(K key) { return get(key) != null; }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    int size();

    /**
     * Tests if there is any key-value pairs in this symbol table.
     *
     * @return {@code true} if there is no key-value pairs in this symbol table; {@code false}
     * otherwise
     */
    default boolean isEmpty() { return size() == 0; }

    /**
     * Returns an iterable object consisting of all the keys in this symbol table.
     *
     * @return an iterable object consisting of all the keys in this symbol table
     */
    Iterable<K> keys();
}