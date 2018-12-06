package madmaw.topcoder.ataleofthreecities;

public class ATaleOfThreeCities {

    public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
        return this._connectBruteForce(ax, ay, bx, by, cx, cy);
    }

    private double _connectBruteForce(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
        double dab = this._connectBruteForce(ax, ay, bx, by);
        double dac = this._connectBruteForce(ax, ay, cx, cy);
        double dbc = this._connectBruteForce(bx, by, cx, cy);
        if( dab < dac && dbc < dac ) {
            return dab + dbc;
        } else if( dac < dab && dbc < dab ) {
            return dac + dbc;
        } else {
            return dab + dac;
        }
    }

    private double _connectBruteForce(int[] ax, int[] ay, int[] bx, int[] by) {
        int min = Integer.MAX_VALUE;
        for( int ia = 0; ia < ax.length; ia++ ) {
            int xa = ax[ia];
            int ya = ay[ia];
            for( int ib=0; ib < bx.length; ib++ ) {
                int xb = bx[ib];
                int yb = by[ib];
                int dx = xa - xb;
                int dy = ya - yb;
                min = Math.min(min, dx*dx + dy*dy);
            }
        }
        return Math.sqrt(min);
    }

}
