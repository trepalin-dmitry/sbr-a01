import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class06TaskETest {
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
                "Alexander_I Nicholaus_I",
                "Peter_II Paul_I",
                "Alexander_I Anna"

        ));

        assertArrayEquals(new String[]{
                        "Paul_I",
                        "Peter_I",
                        "Anna"
                }
                , Class06TaskE.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
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
                "Alexander_I Nicholaus_I"

        ));

        assertArrayEquals(new String[]{
                        "Paul_I"
                }
                , Class06TaskE.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
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
                "Peter_II Paul_I"

        ));

        assertArrayEquals(new String[]{
                        "Peter_I"
                }
                , Class06TaskE.calc(bufferedReader));
    }

    @Test
    public void test04() throws IOException {
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
                "Alexander_I Anna"

        ));

        assertArrayEquals(new String[]{
                        "Anna"
                }
                , Class06TaskE.calc(bufferedReader));
    }

}
