import common.TestBufferedReader;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class Class03TaskDTest {
    @Test
    public void test01() throws IOException {
        TestBufferedReader bufferedReader = new TestBufferedReader();

        bufferedReader.addLine("3");
        bufferedReader.addLine("3");
        bufferedReader.addLine("Russian");
        bufferedReader.addLine("English");
        bufferedReader.addLine("Japanese");
        bufferedReader.addLine("2");
        bufferedReader.addLine("Russian");
        bufferedReader.addLine("English");
        bufferedReader.addLine("1");
        bufferedReader.addLine("English");


        assertArrayEquals(new String[]{
                        "1",
                        "English",
                        "3",
                        "English",
                        "Japanese",
                        "Russian"
                }
                , Class03TaskD.calc(bufferedReader));
    }
}

