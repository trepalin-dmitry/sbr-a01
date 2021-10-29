import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Class02TaskCTest {
    @Test
    public void test01() {
        assertEquals("2", Class02TaskC.get(
                "5 2",
                "0 2"
        ));
    }

    @Test
    public void test02() {
        assertEquals("4 8", Class02TaskC.get(
                "13 4",
                "1 4 8 11"
        ));
    }

    @Test
    public void test03() {
        assertEquals("6 8", Class02TaskC.get(
                "14 6",
                "1 6 8 11 12 13"
        ));
    }
}

