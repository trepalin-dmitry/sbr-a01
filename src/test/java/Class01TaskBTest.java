import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Class01TaskBTest {
    @Test
    public void test01() {
        assertArrayEquals(new Boolean[]{true, true, false}, Class01TaskB.check(
                "8(495)430-23-97",
                "+7-4-9-5-43-023-97",
                "4-3-0-2-3-9-7",
                "8-495-430"
        ));
    }

    @Test
    public void test02() {
        assertArrayEquals(new Boolean[]{false, true, false}, Class01TaskB.check(
                "86406361642",
                "83341994118",
                "86406361642",
                "83341994118"
        ));
    }

    @Test
    public void test03() {
        assertArrayEquals(new Boolean[]{true, false, true}, Class01TaskB.check(
                "+78047952807",
                "+78047952807",
                "+76147514928",
                "88047952807"
        ));
    }
}

