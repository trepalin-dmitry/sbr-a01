import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Class03TaskF {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        var ref = new Object() {
            Set<Integer> variants = new HashSet<>();
        };
        for (int i = 1; i <= n; i++) {
            ref.variants.add(i);
        }

        List<String> result = new ArrayList<>();
        while (true) {
            String line = bufferedReader.readLine();
            if (Objects.equals(line, "HELP")) {
                result.add(ref.variants.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
                break;
            }

            Set<Integer> variantsYes = Arrays
                    .stream(line.split(" "))
                    .map(Integer::parseInt)
                    .filter(f -> ref.variants.remove(f))
                    .collect(Collectors.toSet());

            if (ref.variants.size() >= variantsYes.size()) {
                result.add("NO");
            } else {
                result.add("YES");
                ref.variants = variantsYes;
            }
        }
        return result.toArray(String[]::new);
    }
}

