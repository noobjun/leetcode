package airbnb;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 4/18/16.
 * Often, we want to encode raw IDs in our database by hiding them behind some
 * 2-way decodeable hash. So, a URL which would have at one time been:
 * <p>
 * https://www.airbnb.com/rooms/848662
 * becomes.
 * <p>
 * https://www.airbnb.com/rooms/kljJJ324hjkS_
 * <p>
 * We decode the ID kljJJ324hjkS_ to 848662 on our backend and serve the
 * relevant content. at some point, we start getting 404 errors from clients
 * requesting a certain URL of the form
 * <p>
 * https://www.airbnb.com/rooms/kljjj324hjks_
 * <p>
 * This can happen if certain clients, email services, or url shorteners "
 * sanitize" the url. Unfortunately, this change breaks decoding and the
 * resource cannot be found.
 * To assess how big of a deal this is, we may want to recover the IDs of the.
 * targets that were 404ing.
 * <p>
 * Your task:
 * Given a method decode(testEncStr) which will return the decoded int id if
 * testEncStr is decodeable or will throw an exception or return null (
 * depending on the language) if not, implement a new method decodeFind(String
 * badEncStr) which takes a string and returns the decoded int id.
 */
public class BadEncodeUrl {
    public static void main(String[] args) {
        BadEncodeUrl solution = new BadEncodeUrl();
        List<Integer> res1 = solution.decodeFind("kljjj324hjks_");
        List<Integer> res2 = solution.decodeFind("kljjj324hj_");

        assert res1.get(0) == 848662;
        assert res2.size() == 0;

        System.out.println(res1.get(0));
        System.out.println(res2.size());
    }


    // return type is list because a badEncStr might result in multiple valid ids
    public List<Integer> decodeFind(String badEncStr) {
        List<Integer> result = new LinkedList<>();
        helper(badEncStr, 0, "", result);

        return result;
    }

    public void helper(String badEncStr, int index, String current, List<Integer> result) {
        if (index == badEncStr.length()) {
            try {
                int id = decode(current);
                result.add(id);
            } catch (IllegalArgumentException e) {
                // ignore and log
            }
            return;
        }

        char ch = badEncStr.charAt(index);
        if (Character.isLetter(ch) && Character.isLowerCase(ch)) {
            helper(badEncStr, index + 1, current + Character.toUpperCase(ch), result);
        }
        helper(badEncStr, index + 1, current + ch, result);
    }


    public int decode(String testEncStr) {
        if (testEncStr.equals("kljJJ324hjkS_"))
            return 848662;
        else
            throw new IllegalArgumentException("bad encoded id.");
    }


//    public static void main(String[] args) {
//        BadEncodeUrl solution = new BadEncodeUrl();
//        List<Integer> result = solution.decodeFind("kljjj324hjks_");
//        System.out.println("size: " + result.size());
//        System.out.println(result.get(0));
//    }
//
//    public List<Integer> decodeFind(String badEncStr) {
//        List<Integer> result = new LinkedList<>();
//        helper(badEncStr, "", 0, result);
//        return result;
//    }
//
//    // can further optimize with String builder
//    public void helper(String badEncStr, String current, int index, List<Integer> result) {
//        if (index == badEncStr.length()) {
//            try {
//                int id = decode(current);
//                result.add(id);
//            } catch (IllegalArgumentException e) {
//                // ignore
//            }
//            return;
//        }
//
//        char ch = badEncStr.charAt(index);
//        if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
//            helper(badEncStr, current + Character.toUpperCase(ch), index + 1, result);
//        }
//        helper(badEncStr, current + ch,]]ju
//\ndex + 1, result);
//    }
//
//    public int decode(String str) {
//        if (str.equals("kljJJ324hjkS_"))
//            return 848662;
//        else
//            throw new IllegalArgumentException("Bad id can't be decoded");
//    }
}



