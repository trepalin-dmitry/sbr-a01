import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Class02TaskETest {
    static Random random = new Random();

    @Test
    public void test01() {
        assertEquals(1, Class02TaskE.calculate(
                "1 5 2 1"
        ));
    }

    @Test
    public void test02() {
        assertEquals(24, Class02TaskE.calculate(
                "5 12 4 3"
        ));
    }
}

