import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class05TaskETest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "3",
                "3 2",
                "4 2",
                "5 2"
        ));

        assertArrayEquals(new String[]{
                        "2"
                }
                , Class05TaskE.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "5",
                "13 4",
                "15 1",
                "11 5",
                "12 3",
                "10 3"
        ));

        assertArrayEquals(new String[]{
                        "3"
                }
                , Class05TaskE.calc(bufferedReader));
    }
}

