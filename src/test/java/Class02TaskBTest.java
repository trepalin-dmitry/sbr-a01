import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Class02TaskBTest {
    @Test
    public void test01() {
        assertEquals(6, Class02TaskB.find("10 20 15 10 30 5 1"));
    }

    @Test
    public void test02() {
        assertEquals(1, Class02TaskB.find("15 15 10"));
    }

    @Test
    public void test03() {
        assertEquals(0, Class02TaskB.find("10 15 20"));
    }

    @Test
    public void test04() {
        assertEquals(4, Class02TaskB.find("30 20 15 10 30 5 1"));
    }

    @Test
    public void test05() {
        assertEquals(0, Class02TaskB.find("1 2 3"));
    }

    @Test
    public void test06() {
        assertEquals(2, Class02TaskB.find("10 0 5 2 3"));
    }


    @Test
    public void test07() {
        assertEquals(0, Class02TaskB.find("0 0 0"));
    }

    @Test
    public void test08() {
        assertEquals(0, Class02TaskB.find(""));
    }
}

