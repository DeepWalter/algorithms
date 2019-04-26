package algorithms;


/**
 * An ordered symbol table in which the keys are totally ordered (usually by implementing the
 * {@code Comparable} interface). Besides basic {@link ST} (symbol table) operations, this interface
 * provides many additional operations such as:
 * <ul>
 *   <li>{@link #max} and {@link #min}: return the maximal and minimal key respectively;</li>
 *   <li>{@link #delMax} and {@link #delMin}: shorthand operations to remove the maximum and minimum
 * respectively;</li>
 *   <li>{@link #floor} and {@link #ceiling}: generalization of the usual floor and ceiling
 * operations to keys;</li>
 *   <li>{@link #rank} and {@link #select}: provide an array-like index system for keys.</li>
 * </ul>
 *
 * <p>
 * This interface aims at efficient implementations of the {@code put} and {@code get} operations.
 * </p>
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 *
 * @author DeepWalter
 *
 * @see ST
 */
public interface OrderedST<K extends Comparable<? super K>, V> extends ST<K, V>
{
    /**
     * Returns the smallest key in this ordered symbol table, or {@code null} if this symbol table
     * is empty.
     *
     * @return the smallest key in this ordered symbol table, or {@code null} if this symbol table
     * is empty.
     */
    K min();

    /**
     * Returns the largest key in this ordered symbol table, or {@code null} if this symbol table
     * is empty.
     *
     * @return the largest key in this ordered symbol table, or {@code null} if this symbol table
     * is empty
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
     * while {@code select} provides a quick access to the value at a given rank. Together, they
     * provide an array-like index system for keys.
     * </p>
     *
     * <p>
     * <strong>Note:</strong> when the symbol table is empty, {@code rank} will return {@code 0} on
     * any key.
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
     * @return the key with rank {@code k}
     *
     * @see #rank
     */
    K select(int i);

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