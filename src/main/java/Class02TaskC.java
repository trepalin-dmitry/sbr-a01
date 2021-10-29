import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Class02TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        System.out.println(get(line1, line2));
    }

    public static String get(String line1, String line2) {
        Integer[] line1parsed = parseLine(line1);
        int length = line1parsed[0];
        int size = line1parsed[1];
        Integer[] items = parseLine(line2);

        boolean checkOne = false;
        int middle = length / 2;
        if (length % 2 == 1) {
            checkOne = true;
        }

        for (int i = 0; i < size; i++) {
            int item = items[i];

            if (checkOne && item == middle) {
                return String.valueOf(middle);
            }

            if (i > 0) {
                int itemPrev = items[i - 1];

                if (itemPrev < middle && item >= middle) {
                    return Stream.of(itemPrev, item)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "));
                }
            }
        }

        throw new RuntimeException();
    }

    private static Integer[] parseLine(String line) {
        return
                Arrays.stream(line
                                .split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
    }
}

