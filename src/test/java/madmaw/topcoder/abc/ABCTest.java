package madmaw.topcoder.abc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABCTest {

    private ABC abc;

    @Before
    public void setUp() {
        this.abc = new ABC();
    }

    @Test
    public void topCoderTestCase0() {
        Assert.assertEquals("ABC", this.abc.createString(3, 3));;
    }

    @Test
    public void topCoderTestCase1() {
        Assert.assertEquals("CCC", this.abc.createString(3, 0));;
    }

    @Test
    public void topCoderTestCase2() {
        Assert.assertEquals("", this.abc.createString(5, 10));;
    }

    @Test
    public void testExactLength6() {
        Assert.assertEquals("AABBCC", this.abc.createString(6, 12));;
    }

    @Test
    public void testExactLength9() {
        Assert.assertEquals("AAABBBCCC", this.abc.createString(9, 27));;
    }

    @Test
    public void testExactLength9Plus1() {
        this.confirm(10, 28);
    }

    @Test
    public void testExactLength9Minus1() {
        this.confirm(10, 26);
    }


    private void confirm(int N, int K) {
        String s = this.abc.createString(N, K);
        int count = 0;
        for( int i=0; i<s.length(); i++ ) {
            char c = s.charAt(i);
            for( int j=i+1; j<s.length(); j++ ) {
                char d = s.charAt(j);
                if( c == 'A' && d != 'A' || c == 'B' && d == 'C' ) {
                    count++;
                }
            }
        }
        System.out.println(s);
        Assert.assertEquals(K, count);
        Assert.assertEquals(N, s.length());
    }
}
