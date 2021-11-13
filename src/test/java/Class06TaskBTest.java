import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class06TaskBTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "7 3 2 1 9 5 4 6 8 0"
        ));

        assertArrayEquals(new String[]{
                        "4"
                }
                , Class06TaskB.calc(bufferedReader));
    }
}