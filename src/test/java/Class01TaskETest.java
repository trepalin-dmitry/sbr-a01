import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Class01TaskETest {
    @Test
    public void test01() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "1 1 1",
                "1 1 1",
                "1 1 1"
        }));
    }

    @Test
    public void test02() {
        assertEquals(Class01TaskE.Answers.Yes, Class01TaskE.check(new String[]{
                "2 1 1",
                "1 1 2",
                "2 2 1"
        }));
    }

    @Test
    public void test03() {
        assertEquals(Class01TaskE.Answers.Yes, Class01TaskE.check(new String[]{
                "1 1 1",
                "2 0 2",
                "0 0 0"
        }));
    }

    @Test
    public void test04() {
        assertEquals(Class01TaskE.Answers.Yes, Class01TaskE.check(new String[]{
                "0 0 0",
                "0 1 0",
                "0 0 0"
        }));
    }

    @Test
    public void test051() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "1 1 1",
                "2 2 2",
                "0 0 0"
        }));
    }

    @Test
    public void test052() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "1 2 0",
                "1 2 0",
                "1 2 0"
        }));
    }

    @Test
    public void test06() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "1 2 2",
                "1 0 0",
                "1 2 2"
        }));
    }

    @Test
    public void test07() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "0 0 0",
                "2 0 0",
                "0 0 0"
        }));
    }

    @Test
    public void test080() {
        assertEquals(Class01TaskE.Answers.Yes, Class01TaskE.check(new String[]{
                "1 0 2",
                "2 1 0",
                "0 0 1"
        }));
    }

    @Test
    public void test081() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "1 0 2",
                "2 1 2",
                "0 0 1"
        }));
    }

    @Test
    public void test082() {
        assertEquals(Class01TaskE.Answers.Yes, Class01TaskE.check(new String[]{
                "2 0 1",
                "1 2 1",
                "0 0 2"
        }));
    }

    @Test
    public void test083() {
        assertEquals(Class01TaskE.Answers.No, Class01TaskE.check(new String[]{
                "2 0 1",
                "1 2 1",
                "1 0 2"
        }));
    }
}
