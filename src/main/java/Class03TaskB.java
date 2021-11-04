import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Class03TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static class Answers {
        public static final String YES = "YES";
        public static final String NO = "NO";
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int[] items = Arrays
                .stream(bufferedReader
                        .readLine()
                        .split(" ")
                )
                .mapToInt(Integer::parseInt)
                .toArray();

        int length = items.length;
        Set<Integer> foundItems = new HashSet<>();
        String[] result = new String[length];

        for (int i = 0; i < length; i++) {
            int item = items[i];
            if (foundItems.add(item)) {
                result[i] = Answers.NO;
            } else {
                result[i] = Answers.YES;
            }
        }

        return result;
    }
}

