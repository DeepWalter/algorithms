package algorithms;


public interface StringST<V> extends ST<String, V>
{
    /**
     * Returns the longest key that is a prefix of {@code s}.
     *
     * @param s the string to match
     * @return the longest key that is a prefix of {@code s}
     */
    String longestPrefixOf(String s);

    /**
     * Returns an iterable object over all keys having {@code s} as a prefix.
     *
     * @param s the prefix
     * @return an iterable object over all keys having {@code s} as a prefix
     */
    Iterable<String> keysWithPrefix(String s);

    /**
     * Returns an iterable object over all keys that match {@code s}. Here, {@code .} matches any
     * character.
     *
     * @param s the matching pattern
     * @return an iterable object over all keys that match {@code s}
     */
    Iterable<String> keysThatMatch(String s);
}