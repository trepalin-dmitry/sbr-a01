import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class05TaskCTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "4",
                "1 2 3 4"
        ));

        assertArrayEquals(new String[]{
                        "10"
                }
                , Class05TaskC.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "4",
                "5 4 -10 4"
        ));

        assertArrayEquals(new String[]{
                        "9"
                }
                , Class05TaskC.calc(bufferedReader));
    }
}

