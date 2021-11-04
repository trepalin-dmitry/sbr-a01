import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Class03TaskBTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();
        bufferedReader.addLine("1 2 3 2 3 4");

        assertArrayEquals(new String[]{
                        "NO",
                        "NO",
                        "NO",
                        "YES",
                        "YES",
                        "NO"
                }
                , Class03TaskB.calc(bufferedReader));
    }
}

