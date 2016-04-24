/**
 * Created by jun on 4/23/16.
 * 345. Reverse Vowels of a String
 */
public class P345 {
    public String reverseVowels(String s) {
        if (s == null)
            return null;

        if (s.isEmpty())
            return "";

        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (!isVowel(arr[left]))
                left++;

            if (!isVowel(arr[right]))
                right--;

            if (isVowel(arr[left]) && isVowel(arr[right])) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return String.valueOf(arr);
    }


    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U';
    }
}
