package Queue;
import java.util.*;

class FirstUnique {
    public static String firstUniqueCharStream(String stream) {
        Map<Character, Integer> freq = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char ch : stream.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            q.add(ch);

            // remove repeating chars
            while (!q.isEmpty() && freq.get(q.peek()) > 1) {
                q.poll();
            }

            // check front
            if (!q.isEmpty()) {
                result.append(q.peek());
            } else {
                result.append('#');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String stream = "aabc";
        System.out.println(firstUniqueCharStream(stream)); // Output: a#bb
    }
}
