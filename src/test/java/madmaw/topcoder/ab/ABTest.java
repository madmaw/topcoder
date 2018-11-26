package madmaw.topcoder.ab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABTest {

    private AB ab;

    @Before
    public void setUp() {
        this.ab = new AB();
    }

    @Test
    public void topCoderTestCase0() {
        String s = this.ab.createString(3, 2, "ABB");
        Assert.assertTrue(s, this.ab.matches(s, 3, 2));
    }

    @Test
    public void topCoderTestCase1() {
        String s = this.ab.createString(2, 0, "BA");
        Assert.assertTrue(s, this.ab.matches(s, 2, 0));
    }

    @Test
    public void topCoderTestCase2() {
        Assert.assertEquals("", this.ab.createString(5, 8));
    }

    @Test
    public void topCoderTestCase3() {
        String s = this.ab.createString(10, 12, "BAABBABAAB");
        Assert.assertTrue(s, this.ab.matches(s, 10, 12));
    }

    @Test
    public void testRemainder() {
        String s = this.ab.createString(7, 10, "AAABBAB");
        Assert.assertTrue(s, this.ab.matches(s, 7, 10));
    }

    @Test
    public void testRemainderTooShort() {
        Assert.assertEquals("", this.ab.createString(6, 10));
    }

    @Test
    public void testRemainderTooLong() {
        String s = this.ab.createString(8, 10, "BAAABBAB");
        Assert.assertTrue(s, this.ab.matches(s, 8, 10));
    }

    @Test
    public void testBigRemainder() {
        String s = this.ab.createString(10, 15);
        Assert.assertTrue(s, this.ab.matches(s,10, 15));

    }

    @Test
    public void testEvenSplit() {
        String s = this.ab.createString(7, 12, "AAABBBB");
        Assert.assertTrue(s, this.ab.matches(s,7, 12));

    }

}
