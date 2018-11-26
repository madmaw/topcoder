package madmaw.topcoder.a0paper;

import org.junit.*;


public class A0PaperTest {

    private A0Paper a0Paper;

    @Before
    public void setUp() {
        this.a0Paper = new A0Paper();
    }

    @Test
    public void topCoderTestCase0() {
        Assert.assertEquals("Possible", this.a0Paper.canBuild(new int[]{0, 3}));
    }

    @Test
    public void topCoderTestCase1() {
        Assert.assertEquals("Possible", this.a0Paper.canBuild(new int[]{0, 1, 2}));
    }

    @Test
    public void topCoderTestCase2() {
        Assert.assertEquals("Impossible", this.a0Paper.canBuild(new int[]{0,0,0,0,15}));
    }

    @Test
    public void topCoderTestCase3() {
        Assert.assertEquals("Possible", this.a0Paper.canBuild(new int[]{2,0,0,0,0,0,0,3,2,0,0,5,0,3,0,0,1,0,0,0,5}));
    }

    @Test
    public void singleSheetTest() {
        Assert.assertEquals("Possible", this.a0Paper.canBuild(new int[]{1}));
    }

    @Test
    public void halfSheetTest() {
        Assert.assertEquals("Impossible", this.a0Paper.canBuild(new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void halfSheetTest2() {
        Assert.assertEquals("Possible", this.a0Paper.canBuild(new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}));
    }

}
