import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class Class04TaskBTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("one two one tho three");

        assertArrayEquals(new String[]{
                        "0 0 1 0 0 "
                }
                , Class04TaskB.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("She sells sea shells on the sea shore;");
        bufferedReader.addLine("The shells that she sells are sea shells I'm sure.");
        bufferedReader.addLine("So if she sells sea shells on the sea shore,");
        bufferedReader.addLine("I'm sure that the shells are sea shore shells.");

        assertArrayEquals(new String[]{
                        "0 0 0 0 0 0 1 0 0 1 0 0 1 0 2 2 0 0 0 0 1 2 3 3 1 1 4 0 1 0 1 2 4 1 5 0 0 "
                }
                , Class04TaskB.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("aba aba; aba @?\"");

        assertArrayEquals(new String[]{
                        "0 0 1 0 "
                }
                , Class04TaskB.calc(bufferedReader));
    }
}