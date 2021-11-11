import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class05TaskDTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "1",
                "10 20"
        ));

        assertArrayEquals(new String[]{
                        "10"
                }
                , Class05TaskD.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "1",
                "10 10"
        ));

        assertArrayEquals(new String[]{
                        "0"
                }
                , Class05TaskD.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "2",
                "10 20",
                "20 40"
        ));

        assertArrayEquals(new String[]{
                        "30"
                }
                , Class05TaskD.calc(bufferedReader));
    }
}