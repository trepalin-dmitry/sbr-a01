import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Class05TaskA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] NN = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] MM = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int r_n = -1;
        int r_m = -1;
        int n = 0;
        int m = 0;
        int absMin = Integer.MAX_VALUE;
        while (n < N && m < M) {
            int c_n = NN[n];
            int c_m = MM[m];
            int abs = Math.abs(c_n - c_m);
            if (absMin > abs) {
                absMin = abs;
                r_n = c_n;
                r_m = c_m;
            }

            if (c_n >= c_m) {
                m++;
            } else {
                n++;
            }
        }

        return new String[]{
                String.format("%d %d", r_n, r_m)
        };
    }
}

