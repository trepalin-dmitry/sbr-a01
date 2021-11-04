import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Class03TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();

        Set<String> set2 = new HashSet<>();
        processItems(line2, set2::add);

        AtomicInteger result = new AtomicInteger();
        processItems(line1, s -> {
            if (set2.contains(s)) {
                result.getAndIncrement();
            }
        });

        return new String[]{String.valueOf(result.get())};
    }

    private static void processItems(String line, Consumer<String> consumer) {
        char[] chars = line.toCharArray();
        char prev = '-';
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i > 0) {
                consumer.accept(new String(new char[]{prev, c}));
            }
            prev = c;
        }
    }
}

