package algorithms;


/**
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface OrderedST<K extends Comparable<? super K>, V> extends ST<K, V>
{
    /**
     * Returns the smallest key in this ordered symbol table.
     *
     * @return the smallest key in this ordered symbol table
     */
    K min();

    /**
     * Returns the largest key in this ordered symbol table.
     *
     * @return the largest key in this ordered symbol table
     */
    K max();

    /**
     * Returns the largest key less than or equal to {@code key}, or {@code null} if there is no
     * such element.
     *
     * @param key the key to match
     * @return the largest key less than or equal to {@code key}, or {@code null} if there is no
     * such element
     */
    K floor(K key);

    /**
     * Returns the smallest key greater than or equal to {@code key}, or {@code null} if there is no
     * such element.
     *
     * @param key the key to match
     * @return the smallest key greater than or equal to {@code key}, or {@code null} if there is no
     * such element
     */
    K ceiling(K key);

    /**
     * Returns the number of keys that are less than {@code key}.
     *
     * <p>
     * The methods {@link #rank} and {@link #select} must satisfy:
     * <ul>
     *   <li>{@code rank(select(i)) == i} for all {@code i} between {@code 0} and {@code size()-1}.
     * </li>
     *   <li>{@code select(rank(key)) == key} for all {@code key} in this ordered symbol table.</li>
     * </ul>
     * The {@code rank} method is mainly used for determining where a new key fits in the order,
     * while {@code select} provides a quick access to the value at a given rank.
     * </p>
     *
     * @param key the key to match
     * @return the number of keys that are less than {@code key}
     *
     * @see #select
     */
    int rank(K key);

    /**
     * Returns the key at rank {@code k}.
     *
     * <p>
     * The methods {@link #rank} and {@link #select} must satisfy:
     * <ul>
     *   <li>{@code rank(select(i)) == i} for all {@code i} between {@code 0} and {@code size()-1}.
     * </li>
     *   <li>{@code select(rank(key)) == key} for all {@code key} in this ordered symbol table.</li>
     * </ul>
     * The {@code rank} method is mainly used for determining where a new key fits in the order,
     * while {@code select} provides a quick access to the value at a given rank.
     * </p>
     *
     * @param k the rank
     * @return the key at rank {@code k}
     *
     * @see #rank
     */
    K select(int k);

    /**
     * Removes the smallest key and its value.
     */
    default void delMin() { delete(min()); }

    /**
     * Removes the largest key and its value.
     */
    default void delMax() { delete(max()); }

    /**
     * Returns the number of keys in the interval {@code [low, high]}.
     *
     * @param low low end of the interval
     * @param high high end of the interval
     * @return the number of keys in {@code [how, high]}
     */
    default int size(K low, K high)
    {
        if (high.compareTo(low) < 0) {
            return 0;
        } else if (contains(high)) {
            return rank(high) - rank(low) + 1;
        } else {
            return rank(high) - rank(low);
        }
    }

    /**
     * Returns an iterable object consisting of all keys in the interval {@code [low, high]}.
     *
     * @param low low end of the interval
     * @param high high end of the interval
     * @return an iterable object consisting of all keys in {@code [low, high]}
     */
    Iterable<K> keys(K low, K high);

    default Iterable<K> keys() { return keys(min(), max()); }
}