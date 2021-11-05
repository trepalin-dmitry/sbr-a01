import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Class04TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int w = line[0];
            int h = line[1];
            map.compute(w, (key, oldValue) -> oldValue != null && oldValue >= h ? oldValue : h);
        }

        long result = 0;
        for (Integer value : map.values()) {
            result += (long) value;
        }

        return new String[]{
                String.valueOf(result)
        };
    }
}