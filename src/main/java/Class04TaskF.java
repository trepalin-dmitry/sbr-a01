import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class04TaskF {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        Map<Character, Integer> map1 = readLine(bufferedReader);
        Map<Character, Integer> map2 = readLine(bufferedReader);

        StringBuilder stringBuilder = new StringBuilder();
        map1
                .keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(f -> {
                    Integer value2 = map2.get(f);
                    if (value2 != null) {
                        int repeat;
                        if (stringBuilder.isEmpty() && f == '0'){
                            repeat = 1;
                        }
                        else{
                            repeat = Math.min(map1.get(f), value2);
                        }
                        stringBuilder.append(String.valueOf(f).repeat(repeat));
                    }
                });

        if (stringBuilder.isEmpty()){
            stringBuilder.append("-1");
        }

        return new String[]{
                stringBuilder.toString()
        };
    }

    private static Map<Character, Integer> readLine(BufferedReader bufferedReader) throws IOException {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : bufferedReader.readLine().toCharArray()) {
            result.compute(c, (key, value) -> (value == null ? 0 : value) + 1);
        }
        return result;
    }
}
