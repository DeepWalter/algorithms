package algorithms;


public class Alphabet
{
    private final int RADIX;
    private final char[] characters;

    /**
     * Initialize the alphabet with string {@code s}.
     *
     * @param s the string containing all characters of the alphabet in order
     */
    public Alphabet(String s)
    {
        RADIX = s.length();
        characters = new char[RADIX];
        for (int i = 0; i < RADIX; i++) {
            characters[i] = s.charAt(i);
        }
    }

    /**
     * Returns the radix (i.e. the number of characters in this alphabet).
     *
     * @return the radix of this alphabet
     */
    public int radix()
    {
        return RADIX;
    }

    /**
     * Returns the number of bits needed to represent an index.
     *
     * <p><Strong>Note:</strong><br>
     * When the radix is {@code 0}, this function returns {@code 0} since there is no index to
     * represent; when the radix is {@code 1}, this function returns {@code 1} since at least one
     * bit is needed to represent one index. For other values of radix, this function returns the
     * ceiling of (base 2) logarithm of the radix.
     *
     * @return the number of bits needed to peresent an index
     */
    public int logRadix()
    {
        if (RADIX <= 1) {   // RADIX is a non-negative int
            return RADIX;
        }

        int i = 0;
        int temp = RADIX - 1;   // maximal index
        while (temp != 0) {
            temp >>= 1;
            i++;
        }

        return i;
    }
}