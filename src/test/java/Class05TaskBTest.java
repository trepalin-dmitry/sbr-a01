import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class05TaskBTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "4 4",
                "1 3 5 8"
        ));

        assertArrayEquals(new String[]{
                        "2"
                }
                , Class05TaskB.calc(bufferedReader));
    }
}

