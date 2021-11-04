import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class02TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String line = bufferedReader.readLine();
        System.out.println(calculate(line));
    }

    public static int calculate(String line) {
        int[] l = Arrays.stream(line
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        Map<Integer, Integer> stat = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        for (int value : l) {
            sum += value;
            stat.compute(value, (k, v) -> v == null ? 1 : v + 1);
            if (maxValue < value) {
                maxValue = value;
            }
        }

        if (stat.get(maxValue) == 1) {
            int sumOther = 0;
            for (Map.Entry<Integer, Integer> entry : stat.entrySet()) {
                if (entry.getKey() == maxValue) {
                    continue;
                }

                sumOther += entry.getKey() * entry.getValue();
            }

            int result = maxValue - sumOther;
            if (result > 0) {
                return result;
            }
        }

        return sum;
    }
}

