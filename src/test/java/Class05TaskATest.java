import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class05TaskATest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "2",
                "3 4",
                "3",
                "1 2 3"
        ));


        assertArrayEquals(new String[]{
                        "3 3"
                }
                , Class05TaskA.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "2",
                "4 5",
                "3",
                "1 2 3"

        ));


        assertArrayEquals(new String[]{
                        "4 3"
                }
                , Class05TaskA.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "5",
                "1 2 3 4 5",
                "5",
                "1 2 3 4 5"
        ));


        assertArrayEquals(new String[]{
                        "1 1"
                }
                , Class05TaskA.calc(bufferedReader));
    }
}