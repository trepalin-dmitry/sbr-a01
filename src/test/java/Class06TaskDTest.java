import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class06TaskDTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "9",
                "Alexei Peter_I",
                "Anna Peter_I",
                "Elizabeth Peter_I",
                "Peter_II Alexei",
                "Peter_III Anna",
                "Paul_I Peter_III",
                "Alexander_I Paul_I",
                "Nicholaus_I Paul_I",
                "Anna Nicholaus_I",
                "Peter_II Peter_I",
                "Alexei Paul_I"
        ));

        assertArrayEquals(new String[]{
                        "1 2 0"
                }
                , Class06TaskD.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "9",
                "Peter_II Alexei",
                "Alexei Peter_I",
                "Anna Peter_I",
                "Elizabeth Peter_I",
                "Peter_III Anna",
                "Paul_I Peter_III",
                "Alexander_I Paul_I",
                "Nicholaus_I Paul_I",
                "Anna Nicholaus_I",
                "Peter_II Peter_I",
                "Alexei Paul_I"
        ));

        assertArrayEquals(new String[]{
                        "1 2 0"
                }
                , Class06TaskD.calc(bufferedReader));
    }
}