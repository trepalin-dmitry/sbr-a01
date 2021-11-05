import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Class04TaskDTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("DEPOSIT Ivanov 100");
        bufferedReader.addLine("INCOME 5");
        bufferedReader.addLine("BALANCE Ivanov");
        bufferedReader.addLine("TRANSFER Ivanov Petrov 50");
        bufferedReader.addLine("WITHDRAW Petrov 100");
        bufferedReader.addLine("BALANCE Petrov");
        bufferedReader.addLine("BALANCE Sidorov");


        assertArrayEquals(new String[]{
                        "105",
                        "-50",
                        "ERROR"
                }
                , Class04TaskD.calc(bufferedReader));
    }

    @Test
    public void test02() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "BALANCE Ivanov",
                "BALANCE Petrov",
                "DEPOSIT Ivanov 100",
                "BALANCE Ivanov",
                "BALANCE Petrov",
                "DEPOSIT Petrov 150",
                "BALANCE Petrov",
                "DEPOSIT Ivanov 10",
                "DEPOSIT Petrov 15",
                "BALANCE Ivanov",
                "BALANCE Petrov",
                "DEPOSIT Ivanov 46",
                "BALANCE Ivanov",
                "BALANCE Petrov",
                "DEPOSIT Petrov 14",
                "BALANCE Ivanov",
                "BALANCE Petrov"
                ));

        assertArrayEquals(new String[]{
                        "ERROR",
                        "ERROR",
                        "100",
                        "ERROR",
                        "150",
                        "110",
                        "165",
                        "156",
                        "165",
                        "156",
                        "179"

                }
                , Class04TaskD.calc(bufferedReader));
    }

    @Test
    public void test03() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLines(List.of(
                "BALANCE a",
                "BALANCE b",
                "DEPOSIT a 100",
                "BALANCE a",
                "BALANCE b",
                "WITHDRAW a 20",
                "BALANCE a",
                "BALANCE b",
                "WITHDRAW b 78",
                "BALANCE a",
                "BALANCE b",
                "WITHDRAW a 784",
                "BALANCE a",
                "BALANCE b",
                "DEPOSIT b 849",
                "BALANCE a",
                "BALANCE b"

        ));

        assertArrayEquals(new String[]{
                        "ERROR",
                        "ERROR",
                        "100",
                        "ERROR",
                        "80",
                        "ERROR",
                        "80",
                        "-78",
                        "-704",
                        "-78",
                        "-704",
                        "771"

                }
                , Class04TaskD.calc(bufferedReader));
    }
}