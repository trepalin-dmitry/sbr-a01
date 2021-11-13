import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class06TaskATest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "ADD 2",
                "ADD 3",
                "ADD 2",
                "SEARCH 2",
                "ADD 5",
                "PRINTTREE",
                "SEARCH 7"
        ));

        assertArrayEquals(new String[]{
                        "DONE",
                        "DONE",
                        "ALREADY",
                        "YES",
                        "DONE",
                        "2",
                        ".3",
                        "..5",
                        "NO"
                }
                , Class06TaskA.calc(bufferedReader));
    }
}