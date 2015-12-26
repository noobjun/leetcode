/**
 * Created by jun on 12/25/15.
 * 157. Read N Characters Given Read4
 */
public class P157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int pos = 0;
        char[] four = new char[4];
        int read;
        do {
            read = read4(four);
            if (n < read) {
                read = n;
                n = 0;
            } else {
                n -= read;
            }
            System.arraycopy(four, 0, buf, pos, read);
            pos += read;
        } while (n > 0 && read != 0);
        return pos;
    }
}
