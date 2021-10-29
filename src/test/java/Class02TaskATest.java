import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Class02TaskATest {
    @Test
    public void test01() {
        assertEquals(0,  Class02TaskA.calculate("a"));
    }

    @Test
    public void test02() {
        assertEquals(1,  Class02TaskA.calculate("ab"));
    }

    @Test
    public void test03() {
        assertEquals(4,  Class02TaskA.calculate("cognitive"));
    }
}


