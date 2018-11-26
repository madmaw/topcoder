package madmaw.topcoder.abba;

import org.junit.*;

public class ABBATest {

    private ABBA abba;

    @Before
    public void setUp() {
        this.abba = new ABBA();
    }

    @Test
    public void topCoderTest0() {
        Assert.assertEquals("Impossible", this.abba.canObtain("AB", "ABB"));
    }

    @Test
    public void topCoderTest1() {
        Assert.assertEquals("Impossible", this.abba.canObtain("BBAB", "ABABABABB"));
    }

    @Test
    public void topCoderTest2() {
        Assert.assertEquals("Possible", this.abba.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"));
    }

    @Test
    public void topCoderTest3() {
        Assert.assertEquals("Impossible", this.abba.canObtain("A", "BB"));
    }

}
