import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by jun on 12/24/15.
 * 158. Read N Characters Given Read4 II - Call multiple times
 */
public class P158 extends Reader4 {
    char[] four = new char[4];

    /**
     * fourStart and fourEnd marks the beginning and the end of the four char buffer (fourEnd will be over by 1, "exclusive")
     * I maintain an invariant such that if buffer is non-empty, then fourEnd is > 0
     */
    int fourStart = 0;
    int fourEnd = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
        if (n == 0)
            return 0;

        int pos = 0;
        if (fourEnd > 0) {
            int readFour = Math.min(n, fourEnd - fourStart);
            System.arraycopy(four, fourStart, buf, pos, Math.min(n, readFour));
            fourStart += readFour;
            if (fourStart == fourEnd) {
                fourStart = 0;
                fourEnd = 0;
            }
            n -= readFour;
            pos += readFour;
        }

        if (n > 0) {
            int read;
            do {
                read = read4(four);
                fourStart = 0;
                fourEnd = read;
                if (n < read) {
                    read = n;
                    n = 0;
                } else {
                    n -= read;
                }
                System.arraycopy(four, fourStart, buf, pos, read);
                fourStart += read;
                if (fourStart == fourEnd) {
                    fourEnd = 0;
                    fourStart = 0;
                }
                pos += read;
            } while (n > 0 && read != 0);
        }

        return pos;
    }
}
