package madmaw.topcoder.aseries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ASeriesTest {

    private ASeries aSeries;

    @Before
    public void setUp() {
        this.aSeries = new ASeries();
    }

    @Test
    public void topCoderTestCase0() {
        Assert.assertEquals(5, this.aSeries.longest(new int[]{3,8,4,5,6,2,2}));
    }

    @Test
    public void topCoderTestCase1() {
        Assert.assertEquals(3, this.aSeries.longest(new int[]{-1,-5,1,3}));
    }

    @Test
    public void topCoderTestCase2() {
        Assert.assertEquals(3, this.aSeries.longest(new int[]{-10,-20,-10,-10}));
    }

    @Test
    public void multipleDuplicateTestCase() {
        Assert.assertEquals(3, this.aSeries.longest(new int[]{-10, -20, -20, -10, -10}));
    }

}
