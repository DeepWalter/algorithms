package algorithms;


/**
 * An unordered <em>symbol table</em>. A (unordered) symbol table is a data structure for key-value
 * pairs that supports two operations:
 * <ul>
 *   <li>{@link #put}: <em>insert</em> a new pair into the table;</li>
 *   <li>{@link #get}: <em>search for</em> the value associated with a given key.</li>
 * </ul>
 * Besides these two operations, this interface also provides several other useful operations such
 * as:
 * <ul>
 *  <li>{@link #delete}: <em>delete</em> a key and its value;</li>
 *  <li>{@link #contains}: test if a key is in this symbol table;</li>
 *  <li>{@link #keys}: generate an iterable object over all the keys in this symbol table;</li>
 *  <li>{@link #size}: <em>count</em> the number of key-value pairs in this symbol table;</li>
 *  <li>{@link #isEmpty}: test if this symbol table is empty.</li>
 * </ul>
 *
 * <p>
 * For simplicity, any implementation of this interface should adopt the following conventions:
 * <ul>
 *   <li>No duplicate keys: only one value is associated with each key;</li>
 *   <li>Inserting a key-value pair with existing key overrides the associated value;</li>
 *   <li>Keys must not be {@code null};</li>
 *   <li>No key can be associated with the value {@code null}.</li>
 * </ul>
 * For more information, see Section 3.1 of <em>Algorithms, 4th edition</em>.
 * </p>
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 *
 * @author DeepWalter
 *
 * @see OrderedST
 */
public interface ST<K, V>
{
    /**
     * Puts key-value pair into this symbol table, or removes {@code key} if {@code val} is
     * {@code null}.
     *
     * @param key the key to insert
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