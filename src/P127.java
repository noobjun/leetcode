import java.util.*;

/**
 * Created by jun on 1/18/16.
 * 127. Word Ladder
 */
public class P127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        wordList.add(endWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            if (word.equals(endWord))
                return pair.step;

            char[] newWord = word.toCharArray();

            for (int i = 0; i < newWord.length; i++) {
                char saved = newWord[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    newWord[i] = c;

                    String newString = new String(newWord);
                    if (wordList.contains(newString)) {
                        queue.offer(new Pair(newString, pair.step + 1));
                        wordList.remove(newString);
                    }
                }
                newWord[i] = saved;
            }

        }

        return 0;
    }

    public static class Pair {
        String word;
        int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
