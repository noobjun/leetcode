package airbnb;


import java.util.*;

/**
 * Created by jun on 4/17/16.
 */
public class PalindromePair {

    public static void main(String[] args) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);
        set.add(a1);
        set.add(a2);
        System.out.println(set.size());
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);

        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            for (int i = 0; i <= word.length(); i++) {
                String a = word.substring(0, i);
                String b = word.substring(i);

                if (isPalindrome(a) && map.containsKey(reverse(b))) {
                    int idx = map.get(reverse(b));
                    if (idx != k) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(idx);
                        list.add(k);
                        result.add(list);
                    }
                }

                if (isPalindrome(b) && map.containsKey(reverse(a)) && b.length() != 0) {
                    int idx = map.get(reverse(a));
                    if (idx != k) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(k);
                        list.add(idx);
                        result.add(list);
                    }
                }
            }
        }


        return result;
    }

    public String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }

    public boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l <= r) {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
