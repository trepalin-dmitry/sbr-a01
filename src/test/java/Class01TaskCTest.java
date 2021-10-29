import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Class01TaskCTest {
    @Test
    public void test01() {
        assertEquals(4, Class01TaskC.calculate(10, 5, 2));
    }

    @Test
    public void test02() {
        assertEquals(3, Class01TaskC.calculate(13, 5, 3));
    }

    @Test
    public void test03() {
        assertEquals(4, Class01TaskC.calculate(14, 5, 3));
    }

    @Test
    public void test041() {
        assertEquals(0, Class01TaskC.calculate(1, 2, 2));
    }

    @Test
    public void test042() {
        assertEquals(0, Class01TaskC.calculate(5, 2, 3));
    }
}

