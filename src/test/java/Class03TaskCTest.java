import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class Class03TaskCTest {
    static Random random = new Random();

    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();
        bufferedReader.addLine("ABBACAB");
        bufferedReader.addLine("BCABB");

        assertArrayEquals(new String[]{
                        "4"
                }
                , Class03TaskC.calc(bufferedReader));
    }

    private static void bigTestInternal(int length) throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        String line1 = randomString(length);
        System.out.println("line1 = " + line1);
        bufferedReader.addLine(line1);

        String line2 = randomString(length);
        System.out.println("line2 = " + line2);
        bufferedReader.addLine(line2);

        System.out.println("Class03TaskC.calc(bufferedReader) = " + Arrays.toString(Class03TaskC.calc(bufferedReader)));
    }

    @Test
    public void test02() throws IOException {
        bigTestInternal(100);
    }

    @Test
    public void test03() throws IOException {
        bigTestInternal(10000);
    }

    private static String randomString(int length) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}

