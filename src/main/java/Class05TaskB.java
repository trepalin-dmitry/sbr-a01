import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Class05TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int[] line1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line1[0];
        int r = line1[1];
        int[] d = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long result = 0;
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (d[j] - d[i] > r) {
                result += n - j;
                i += 1;
            } else {
                j += 1;
            }
        }

        return new String[]{
                String.valueOf(result)
        };
    }
}