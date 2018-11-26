package madmaw.topcoder.anewhope;

import org.junit.Assert;
import org.junit.*;

public class ANewHopeTest {

    private ANewHope aNewHope;

    @Before
    public void setUp() {
        this.aNewHope = new ANewHope();
    }

    @Test
    public void topCoderTestCase0() {
        int[] firstWeek = {1, 2, 3, 4};
        int[] lastWeek = {4, 3, 2, 1};
        int D = 3;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        Assert.assertEquals(4, count);
    }

    @Test
    public void topCoderTestCase1() {
        int[] firstWeek = {8,5,4,1,7,6,3,2};
        int[] lastWeek = {2,4,6,8,1,3,5,7};
        int D = 3;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        Assert.assertEquals(3, count);
    }

    @Test
    public void topCoderTestCase2() {
        int[] firstWeek = {1,2,3,4};
        int[] lastWeek = {1,2,3,4};
        int D = 2;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        Assert.assertEquals(1, count);
    }

    @Test
    public void shuffleDownTest() {
        int[] firstWeek = {1, 2, 3, 4};
        int[] lastWeek = {1, 3, 2, 4};
        int D = 3;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        Assert.assertEquals(2, count);
    }

    @Test
    public void zeroTimeWashTest() {
        int[] firstWeek = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] lastWeek = {8, 7, 6, 5, 1, 2, 3, 4};
        int D = 1;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        Assert.assertEquals(2, count);
    }

    @Test
    public void shuffleUpTest() {
        int[] firstWeek = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] lastWeek = {5, 6, 7, 8, 4, 3, 2, 1};
        int D = 7;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        Assert.assertEquals(5, count);
    }

    @Test
    public void shuffleUpTest2() {
        int[] firstWeek = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] lastWeek = {5, 7, 6, 8, 9, 4, 3, 2, 1};
        int D = 8;
        int count = aNewHope.count(firstWeek, lastWeek, D);

        Assert.assertEquals(6, count);

    }

    @Test
    public void shuffleUpTest3() {
        int[] firstWeek = {1, 2, 3, 4, 5, 6, 7};
        int[] lastWeek = {5, 6, 7, 4, 3, 2, 1};
        int D = 6;
        int count = aNewHope.count(firstWeek, lastWeek, D);
        //System.out.println(aNewHope.slowCount(firstWeek, lastWeek, D));

        Assert.assertEquals(5, count);

    }


    @Test
    public void fastVsSlowTest() {

        for( int length = 4; length < 5; length ++ ) {
            int[] list = new int[length];
            for( int i=0; i<length; i++ ) {
                list[i] = i+1;
            }
            for( int D = 1; D<length; D++ ) {

                // do all combinations


            }
        }


    }

}