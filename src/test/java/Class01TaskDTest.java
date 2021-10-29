import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Class01TaskDTest {
    @Test
    public void test01() {
        assertEquals(0, Class01TaskD.check(1, 2, 2003));
    }

    @Test
    public void test02() {
        assertEquals(1, Class01TaskD.check(2, 29, 2008));
    }

    @Test
    public void test03() {
        assertEquals(1, Class01TaskD.check(5, 5, 2008));
    }
}

