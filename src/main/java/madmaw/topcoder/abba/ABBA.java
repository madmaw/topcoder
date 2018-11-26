package madmaw.topcoder.abba;

public class ABBA {
    public String canObtain(String initial, String target) {
        boolean ok = this._canObtain(initial, target);
        return ok?"Possible":"Impossible";
    }

    private boolean _canObtain(String s, String target) {
        if( target.equals(s) ) {
            return true;
        } else if( target.length() <= s.length() ) {
            return false;
        } else if (target.endsWith("A")) {
            // remove the A
            return this._canObtain(s, target.substring(0, target.length() - 1) );
        } else if( target.endsWith("B") ) {
            // remove the B and reverse
            String reversed = new StringBuilder(target.substring(0, target.length() - 1)).reverse().toString();
            return this._canObtain(s, reversed);
        } else {
            throw new RuntimeException("unexpected input "+target);
        }
    }

    /**
     * There's a faster way to do this than the solution below (I looked it up, so I don't really deserve much credit for the above).
     */
    private boolean _canObtainSlow(String s, String target) {
        if( s.equals(target) ) {
            return true;
        } else if( s.length() < target.length() ) {
            String sA = s + "A";
            String sB = new StringBuilder(s).reverse().toString() + "B";
            return this._canObtain(sA, target) || this._canObtain(sB, target);
        } else {
            return false;
        }
    }

}