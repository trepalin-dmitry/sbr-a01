import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Class01TaskATest {
    @Test
    public void test01() {
        assertTrue(Class01TaskA.check(1, 1, 1, 1, 1));
    }

    @Test
    public void test02() {
        assertFalse(Class01TaskA.check(2, 2, 2, 1, 1));
    }
}

