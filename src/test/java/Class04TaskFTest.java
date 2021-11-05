import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class04TaskFTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "280138",
                "798081"

        ));


        assertArrayEquals(new String[]{
                        "8810"
                }
                , Class04TaskF.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "123",
                "456"
        ));


        assertArrayEquals(new String[]{
                        "-1"
                }
                , Class04TaskF.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "100",
                "200"
        ));


        assertArrayEquals(new String[]{
                        "0"
                }
                , Class04TaskF.calc(bufferedReader));
    }
}
