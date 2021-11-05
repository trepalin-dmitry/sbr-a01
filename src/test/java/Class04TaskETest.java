import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class04TaskETest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "3",
                "AAB"
        ));


        assertArrayEquals(new String[]{
                        "ABA"
                }
                , Class04TaskE.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "6",
                "QAZQAZ"
        ));


        assertArrayEquals(new String[]{
                        "AQZZQA"
                }
                , Class04TaskE.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "6",
                "ABCDEF"
        ));


        assertArrayEquals(new String[]{
                        "A"
                }
                , Class04TaskE.calc(bufferedReader));
    }
}