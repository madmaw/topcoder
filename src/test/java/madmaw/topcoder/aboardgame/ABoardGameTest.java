package madmaw.topcoder.aboardgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABoardGameTest {

    private ABoardGame aBoardGame;

    @Before
    public void setUp() {
        this.aBoardGame = new ABoardGame();
    }

    @Test
    public void topCoderTestCase0() {
        Assert.assertEquals("Alice", this.aBoardGame.whoWins(new String[]{".....A", "......", "..A...", "...B..", "......", "......"}));
    }

    @Test
    public void topCoderTestCase1() {
        Assert.assertEquals("Bob", this.aBoardGame.whoWins(new String[]{"AAAA", "A.BA", "A..A", "AAAA"}));
    }

    @Test
    public void topCoderTestCase2() {
        Assert.assertEquals("Draw", this.aBoardGame.whoWins(new String[]{"..", ".."}));
    }

    @Test
    public void topCoderTestCase3() {
        Assert.assertEquals("Alice", this.aBoardGame.whoWins(new String[]{"BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB", ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.", ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...."}));
    }

    @Test
    public void topCoderTestCase4() {
        Assert.assertEquals("Bob", this.aBoardGame.whoWins(new String[]{"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"}));
    }

    @Test
    public void topCoderTestCase5() {
        Assert.assertEquals("Draw", this.aBoardGame.whoWins(new String[]{"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"}));
    }

}
