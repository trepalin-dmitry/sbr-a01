import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Class01TaskA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = readInt(bufferedReader);
        int b = readInt(bufferedReader);
        int c = readInt(bufferedReader);
        int d = readInt(bufferedReader);
        int e = readInt(bufferedReader);
        System.out.println((check(a, b, c, d, e) ? Answers.Yes : Answers.No));
    }

    private static final class Answers {
        public static final String Yes = "YES";
        public static final String No = "NO";
    }

    private static int readInt(BufferedReader bufferedReader) throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static boolean check(int a, int b, int c, int d, int e) {
        Rect hole = new Rect(d, e);

        return Stream.of(
                new Rect(a, b),
                new Rect(b, c),
                new Rect(a, c)
        )
                .anyMatch(hole::moreOrEqual);
    }

    private static class Rect {
        private final int min;
        private final int max;

        private Rect(int value1, int value2) {
            this.min = Math.min(value1, value2);
            this.max = Math.max(value1, value2);
        }

        public boolean moreOrEqual(Rect rect){
            return this.min >= rect.min && this.max >= rect.max;
        }
    }
}

