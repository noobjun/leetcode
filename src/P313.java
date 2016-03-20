/**
 * Created by jun on 3/8/16.
 * 313. Super Ugly Number
 */
public class P313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglies = new int[n];
        uglies[0] = 1;

        int[] pointers = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < pointers.length; j++)
                min = Math.min(min, uglies[pointers[j]] * primes[j]);

            for (int j = 0; j < pointers.length; j++)
                if (uglies[pointers[j]] * primes[j] == min) {
                    pointers[j]++;
                }

            uglies[i] = min;
        }

        return uglies[n - 1];
    }
}
