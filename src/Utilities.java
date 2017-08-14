import java.lang.reflect.Array;

/**
 * Contains utility functions
 * @author drageset
 */
public class Utilities {


    /**
     * Concatenate two arrays of the same type, which can be any type
     *
     * @param a the first array you wish to concatenate to the beginning of the second
     * @param b the second array you wish to concatenate to the end of the first
     * @return an array containing exactly a concatenated to b.
     */
    public static <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }
}
