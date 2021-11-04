import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class Class03TaskETest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("19 3");
        bufferedReader.addLine("2 3");
        bufferedReader.addLine("3 5");
        bufferedReader.addLine("9 8");

        assertArrayEquals(new String[]{
                        "8"}
                , Class03TaskE.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("5 2");
        bufferedReader.addLine("1 2");
        bufferedReader.addLine("2 2");

        assertArrayEquals(new String[]{
                        "5"}
                , Class03TaskE.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("1000 1");
        bufferedReader.addLine("1 1");

        assertArrayEquals(new String[]{
                        "715"}
                , Class03TaskE.calc(bufferedReader));
    }
}

