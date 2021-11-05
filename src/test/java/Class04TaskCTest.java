import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class Class04TaskCTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("3");
        bufferedReader.addLine("3 1");
        bufferedReader.addLine("2 2");
        bufferedReader.addLine("3 3");

        assertArrayEquals(new String[]{
                        "5"
                }
                , Class04TaskC.calc(bufferedReader));
    }
}