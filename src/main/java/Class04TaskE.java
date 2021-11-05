import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Class04TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
        SortedMap<Character, Integer> map = new TreeMap<>();
        for (char c : bufferedReader.readLine().toCharArray()) {
            map.compute(c, (key, value) -> (value == null ? 0 : value) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();

        Character middle = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int value = entry.getValue();

            if (middle == null && value % 2 == 1) {
                middle = c;
            }

            stringBuilder.append(String.valueOf(c).repeat(value / 2));
        }

        StringBuilder result = new StringBuilder();
        result.append(stringBuilder);
        if (middle != null) {
            result.append(middle);
        }
        result.append(stringBuilder.reverse());

        return new String[]{
                result.toString()
        };
    }
}