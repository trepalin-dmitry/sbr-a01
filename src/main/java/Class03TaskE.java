import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Class03TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int[] line1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = line1[0];
        int K = line1[1];
        int[] a = new int[K];
        int[] b = new int[K];
        for (int i = 0; i < K; i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            a[i] = line[0];
            b[i] = line[1];
        }

        Set<Integer> z = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int currZ = a[i];
            int currB = b[i];
            while (currZ <= N) {
                int d = currZ % 7;
                if (d != 0 && d != 6) {
                    z.add(currZ);
                }
                currZ += currB;
            }
        }

        return new String[]{String.valueOf(z.size())};
    }
}

