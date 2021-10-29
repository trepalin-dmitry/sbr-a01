import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class02TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String line = bufferedReader.readLine();
        System.out.println(find(line));
    }

    public static int find(String line) {
        if (line == null || line.equals("")) {
            return 0;
        }

        Integer[] values = Arrays
                .stream(line
                        .split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int length = values.length;

        List<Variant> variants = new ArrayList<>();
        Map<Integer, ResultInfo> results = new HashMap<>();
        int winnerValue = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int value = values[i];

            if (winnerValue <= value) {
                winnerValue = value;
            }

            int finalI = i;
            results.compute(value, (k, v) -> {
                if (v == null) {
                    v = new ResultInfo(finalI);
                }
                v.count++;
                return v;
            });

            if (i == 0 || i == (length - 1)) {
                continue;
            }

            if (value % 10 != 5) {
                continue;
            }

            if (values[i + 1] >= value) {
                continue;
            }

            variants.add(new Variant(value, i));
        }

        int winnerFirstPosition = results.get(winnerValue).firstPosition;

        Optional<Integer> foundValue = variants
                .stream()
                .filter(f -> f.position > winnerFirstPosition)
                .map(m -> m.value)
                .max(Integer::compare);

        if (foundValue.isEmpty()) {
            return 0;
        }

        return results
                .entrySet()
                .stream()
                .filter(f -> f.getKey() > foundValue.get())
                .map(m -> m.getValue().count)
                .reduce(Integer::sum)
                .orElse(0) + 1;
    }

    private static class Variant {
        private final int value;
        private final int position;

        private Variant(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }

    private static class ResultInfo {
        private int count = 0;
        private final int firstPosition;

        private ResultInfo(int firstPosition) {
            this.firstPosition = firstPosition;
        }
    }
}

