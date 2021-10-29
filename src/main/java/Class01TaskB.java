import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Class01TaskB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String newNumber = bufferedReader.readLine();
        String number1 = bufferedReader.readLine();
        String number2 = bufferedReader.readLine();
        String number3 = bufferedReader.readLine();

        for (boolean result : check(newNumber, number1, number2, number3)) {
            System.out.println(result ? Answers.Yes : Answers.No);
        }
    }

    private static final class Answers {
        public static final String Yes = "YES";
        public static final String No = "NO";
    }

    public static Boolean[] check(String newNumber, String number1, String number2, String number3) {
        String finalNewNumber = cleanupNumber(newNumber);
        return Stream
                .of(number1, number2, number3)
                .map(m -> Objects.equals(cleanupNumber(m), finalNewNumber))
                .toArray(Boolean[]::new);
    }

    private static String cleanupNumber(String source) {
        String result = source.replaceAll("[+\\-()]", "");
        int length = result.length();
        if (length == 11) {
            result = result.substring(1);
        } else if (length == 7) {
            result = "495" + result;
        }
//        System.out.println("source = " + source);
//        System.out.println("result = " + result);
        return result;
    }
}

