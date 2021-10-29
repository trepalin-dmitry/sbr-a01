import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class01TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] source = new String[Size];
        for (int i = 0; i < source.length; i++) {
            source[i] = bufferedReader.readLine();
        }
        System.out.println(check(source));
    }

    public static final class Answers {
        public static final String Yes = "YES";
        public static final String No = "NO";
    }

    private static final int Size = 3;

    public static String check(String[] source) {
        Integer[][] items = new Integer[Size][Size];
        for (int i = 0; i < Size; i++) {
            items[i] = Arrays.stream(source[i]
                            .split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        int size1 = 0;
        int size2 = 0;
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                int value = items[i][j];
                switch (value) {
                    case 1 -> size1++;
                    case 2 -> size2++;
                }
            }
        }

        if (!( size1 == size2 || size1 == (size2 + 1))){
            return Answers.No;
        }

        // Проверяем наличие более одной линии (разных отметок)
        List<Point[]> lines = new ArrayList<>();
        for (int i = 0; i < Size; i++) {
            lines.add(new Point[]{new Point(i, 0), new Point(i, 1), new Point(i, 2)});
            lines.add(new Point[]{new Point(0, i), new Point(1, i), new Point(2, i)});
        }
        lines.add(new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2)});
        lines.add(new Point[]{new Point(2, 0), new Point(1, 1), new Point(0, 2)});

        boolean line1exists = false;
        boolean line2exists = false;
        for (Point[] line : lines) {
            Set<Integer> values = new HashSet<>();
            for (Point point : line) {
                values.add(items[point.i][point.j]);
            }

            if (values.size() != 1){
                continue;
            }

            int lineValue = values
                    .stream()
                    .findFirst()
                    .orElseThrow();

            if (lineValue == 0){
                continue;
            }

            if (lineValue == 1){
                line1exists = true;
            }

            if (lineValue == 2){
                line2exists = true;
            }

            if (line1exists && line2exists){
                return Answers.No;
            }
        }

        if ((line1exists && size1 != (size2 + 1)) || (line2exists && size1 != size2)){
            return Answers.No;
        }

        return Answers.Yes;
    }

    private static class Point {
        private final int i;
        private final int j;

        private Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
