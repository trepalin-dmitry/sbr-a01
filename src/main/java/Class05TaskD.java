import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class05TaskD {
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
            int l = line[0];
            int r = line[1];
            map.merge(l, 1, Integer::sum);
            map.merge(r, -1, Integer::sum);
        }

        long len = 0;
        int sum = 0;
        int sum_prev = Integer.MIN_VALUE;
        boolean first = true;
        int key_prev = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            int key = entry.getKey();

            if (first){
                 first = false;
            } else {
                if (sum_prev > 0){
                    len += (long) key - (long) key_prev;
                }
            }

            key_prev = key;
            sum_prev = sum;
        }

        return new String[]{
                String.valueOf(len)
        };
    }
}

