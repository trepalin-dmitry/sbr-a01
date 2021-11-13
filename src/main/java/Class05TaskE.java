import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class05TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int t = line[0];
            int l = line[1];
            map.merge(t, 1, Integer::sum);
            map.merge(t + l, -1, Integer::sum);
        }

        long sum = 0;
        long max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            if (max < sum) {
                max = sum;
            }
        }

        return new String[]{
                String.valueOf(max)
        };
    }
}

