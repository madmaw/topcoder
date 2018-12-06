package madmaw.topcoder.atoughgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AToughGameTest {

    private AToughGame aToughGame;

    @Before
    public void setUp() {
        this.aToughGame = new AToughGame();
    }

    @Test
    public void topCoderTestCase0() {
        Assert.assertEquals(
                10,
                this.aToughGame.expectedGain(
                        new int[] {1000,500},
                        new int[] {3,4}
                ),
                .000001
        );
    }

    @Test
    public void topCoderTestCase1() {
        Assert.assertEquals(
                3003.9999999999977,
                this.aToughGame.expectedGain(
                        new int[] {1000,1},
                        new int[] {3,4}
                ),
                .000001
        );
    }

    @Test
    public void topCoderTestCase2() {
        Assert.assertEquals(
                16.626830517153095,
                this.aToughGame.expectedGain(
                        new int[] {500,500,500,500,500},
                        new int[] {1,2,3,4,5}
                ),
                .000001
        );
    }

}
