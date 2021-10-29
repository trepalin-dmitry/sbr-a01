import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Class02TaskDTest {
    static Random random = new Random();

    @Test
    public void test01() {
        assertEquals(7, Class02TaskD.calculate(
                "4 2",
                "45 52 47 46"
        ));
    }

    @Test
    public void test02() {
        testCore(10, 2, 10_000, 1, 100, -1000, 1000);
    }

    @Test
    public void test03() {
        testCore(10, 2, 10_000, 1, 100, -2_000, -1_500);
    }

    @Test
    public void test04() {
        testCore(10, 2, 10_000, 1, 100, 1_500, 2_000);
    }


    private void testCore(int count, int n_min, int n_max, int k_min, int k_max, int b_min, int b_max) {
        for (int t = 0; t < count; t++) {
            int n = getRandomNumber(
                    n_min,
                    n_max
            );

            int k = getRandomNumber(
                    k_min,
                    k_max
            );

            int[] b = getRandomNumbers(n, b_min, b_max);

            System.out.println("b = " + Arrays.toString(b));

            int e = Arrays.stream(b).max().orElseThrow() - Arrays.stream(b).min().orElseThrow();

            for (int i = 0; i < k; i++) {
                confuse(b);
            }

            String line1 = String.format("%s %s", n, k);
            String line2 = Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));

            System.out.println("line1 = " + line1);
            System.out.println("line2 = " + line2);

            assertEquals(e, Class02TaskD.calculate(
                    line1,
                    line2
            ));
        }
    }

    private static void confuse(int[] a) {
        long s = IntStream.of(a).mapToLong(m -> m).sum();
        int length = a.length;
        for (int i = 0; i < length; i++) {
            a[i] = (int) (s - (long) a[i]);
        }
    }

    public int getRandomNumber(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public int[] getRandomNumbers(int size, int min, int max) {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = getRandomNumber(min, max);
        }

        return result;
    }
}
