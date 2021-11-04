import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class Class03TaskFTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("10");
        bufferedReader.addLine("1 2 3 4 5");
        bufferedReader.addLine("2 4 6 8 10");
        bufferedReader.addLine("HELP");

        assertArrayEquals(new String[]{
                        "NO",
                        "YES",
                        "6 8 10"
                }
                , Class03TaskF.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("10");
        bufferedReader.addLine("1");
        bufferedReader.addLine("2");
        bufferedReader.addLine("3");
        bufferedReader.addLine("4");
        bufferedReader.addLine("5");
        bufferedReader.addLine("6");
        bufferedReader.addLine("7");
        bufferedReader.addLine("8");
        bufferedReader.addLine("9");
        bufferedReader.addLine("HELP");


        assertArrayEquals(new String[]{
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "10"
                }
                , Class03TaskF.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("16");
        bufferedReader.addLine("1 2 3 4 5 6 7 8");
        bufferedReader.addLine("9 10 11 12");
        bufferedReader.addLine("13 14");
        bufferedReader.addLine("16");
        bufferedReader.addLine("HELP");

        assertArrayEquals(new String[]{
                        "NO",
                        "NO",
                        "NO",
                        "NO",
                        "15"
                }
                , Class03TaskF.calc(bufferedReader));
    }
}
