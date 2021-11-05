import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Class04TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            for (String s : bufferedReader.readLine().split(" ")) {
                if (s == null || s.equals("")) {
                    continue;
                }

                map.compute(s, (key, value) -> {
                    if (value == null) {
                        value = 0;
                    }

                    stringBuilder.append(value).append(" ");
                    return value + 1;
                });
            }
        }

        return new String[]{stringBuilder.toString()};
    }
}

