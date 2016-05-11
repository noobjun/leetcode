package airbnb;


import java.util.*;

/**
 * Created by jun on 4/17/16.
 */
public class PalindromePair {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new LinkedList<>();

        Map<String, Integer> map = new HashMap<>(); // key is word, and value is its index
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);


        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                String rLeft = reverse(left); // this will have a performance impact on leetcode original problem
                String rRight = reverse(right);

                // left is the center
                if (isPalindrome(left) && map.containsKey(rRight)) {
                    if (map.get(rRight) != i)
                        result.add(Arrays.asList(map.get(rRight), i));

                }

                // right is the center
                if (isPalindrome(right) && map.containsKey(rLeft) && j != word.length()) {
                    if (map.get(rLeft) != i)
                        result.add(Arrays.asList(i, map.get(rLeft)));
                }
            }
        }

        return result;
    }

    private String reverse(String str) {
        if (str == null || str.length() == 1)
            return str;

        String result = "";
        for (int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);

        return result;
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1)
            return true;

        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }


//    public List<List<Integer>> palindromePairs(String[] words) {
//        Map<String, Integer> map = new HashMap<>();
//        List<List<Integer>> result = new LinkedList<>();
//
//        for (int i = 0; i < words.length; i++)
//            map.put(words[i], i);
//
//        for (int k = 0; k < words.length; k++) {
//            String word = words[k];
//            for (int i = 0; i <= word.length(); i++) {
//                String a = word.substring(0, i);
//                String b = word.substring(i);
//
//                if (isPalindrome(a) && map.containsKey(reverse(b))) {
//                    int idx = map.get(reverse(b));
//                    if (idx != k) {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(idx);
//                        list.add(k);
//                        result.add(list);
//                    }
//                }
//
//                if (isPalindrome(b) && map.containsKey(reverse(a)) && b.length() != 0) {
//                    int idx = map.get(reverse(a));
//                    if (idx != k) {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(k);
//                        list.add(idx);
//                        result.add(list);
//                    }
//                }
//            }
//        }
//
//
//        return result;
//    }
//
//    public String reverse(String str) {
//        String result = "";
//        for (int i = str.length() - 1; i >= 0; i--)
//            result += str.charAt(i);
//        return result;
//    }
//
//    public boolean isPalindrome(String str) {
//        int l = 0;
//        int r = str.length() - 1;
//
//        while (l <= r) {
//            if (str.charAt(l) != str.charAt(r))
//                return false;
//            l++;
//            r--;
//        }
//        return true;
//    }
}
