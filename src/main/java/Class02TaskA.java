import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Class02TaskA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        System.out.println(calculate(line));
    }

    public static int calculate(String line) {
        char[] array = line.toCharArray();
        int length = array.length;
        int halfLength = length / 2;
        int result = 0;
        for (int i = 0; i < halfLength; i++) {
            if (array[i] != array[length - i - 1]) {
                result++;
            }
        }
        return result;
    }
}

