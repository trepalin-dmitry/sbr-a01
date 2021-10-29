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

    public static int calculate(String line1, String line2) {
        int[] line1parsed = parseLine(line1);
        int n = line1parsed[0];
        int k = line1parsed[1];
        int[] b = parseLine(line2);
//
//        for (int i = 0; i < k; i++) {
//            deConfuse(b);
//        }

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

        return max - min;
    }

    private static int[] parseLine(String line) {
        return Arrays.stream(line
                        .split(" "))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .toArray();
    }

    private static void deConfuse(int[] source) {
//        System.out.println("source = " + Arrays.toString(source));

        int n = source.length;
        long S = IntStream
                .of(source)
                .mapToLong(m -> m)
                .sum()
                / (n - 1);

//        System.out.println("S = " + S);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            long r = S;

            for (int i1 = 0; i1 < n; i1++) {
                if (i1 == i) {
                    continue;
                }

                r -= source[i1];
            }

            result[i] = (int) r;
        }

        System.arraycopy(result, 0, source, 0, n);
//        System.out.println("result = " + Arrays.toString(result));
    }
}

