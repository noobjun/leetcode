/**
 * Created by jun on 5/4/16.
 * 190. Reverse Bits
 */
public class P190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // shift result
            result <<= 1;

            int bit = n & 1;
            result |= bit;

            // shift
            n >>= 1;
        }
        return result;
    }
}
