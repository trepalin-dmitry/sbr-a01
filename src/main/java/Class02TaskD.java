import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Class02TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        System.out.println(calculate(line1, line2));
    }

    public static long calculate(String line1, String line2) {
        int[] line1parsed = parseLine(line1);
        int n = line1parsed[0];
        int[] b = parseLine(line2);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int bb = b[i];
            if (min > bb) {
                min = bb;
            }
            if (max < bb) {
                max = bb;
            }
        }

        return (long) max - (long) min;
    }

    private static int[] parseLine(String line) {
        return Arrays.stream(line
                        .split(" "))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .toArray();
    }
}

