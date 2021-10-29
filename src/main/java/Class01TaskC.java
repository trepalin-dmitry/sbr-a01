import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Class01TaskC {
    public static void main(String[] args) throws IOException {
        Integer[] source = Arrays
                .stream(new BufferedReader(new InputStreamReader(System.in))
                        .readLine()
                        .split(" ")
                )
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(calculate(source[0], source[1], source[2]));
    }

    public static int calculate(int n, int k, int m) {
        if (m > k) {
            return 0;
        }

        if (k > n){
            return 0;
        }

        // Деталей на заготовку
        int d_z = k / m;
        // Возврат с заготовки
        int z_r = k % m;
        // Расход на заготовку с учетов возврата
        int n_per = k - z_r;

        return (n - z_r) / n_per * d_z;
    }
}

