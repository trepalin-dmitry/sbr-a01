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
        Set<Integer> variants = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            variants.add(i);
        }

        List<String> result = new ArrayList<>();
        while (true) {
            String line = bufferedReader.readLine();
            if (Objects.equals(line, "HELP")) {
                result.add(variants.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
                break;
            }

            Set<Integer> lineSet = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
            Set<Integer> variantsNo = new HashSet<>(variants);
            variantsNo.removeAll(lineSet);

            int variantsSize = variants.size();
            int variantsNoSize = variantsNo.size();

            if (variantsNoSize >= (variantsSize - variantsNoSize)) {
                result.add("NO");
                variants = variantsNo;
            } else {
                result.add("YES");
                variants.removeAll(variantsNo);
            }
        }
        return result.toArray(String[]::new);
    }
}
