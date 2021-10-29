import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Class01TaskD {
    public static void main(String[] args) throws IOException {
        Integer[] source = Arrays
                .stream(new BufferedReader(new InputStreamReader(System.in))
                        .readLine()
                        .split(" ")
                )
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(check(source[0], source[1], source[2]));
    }

    public static int check(int x, int y, int z) {
        if (x == y) {
            return 1;
        }

        if (x <= 12 && y <= 12) {
            return 0;
        }

        return 1;
    }
}