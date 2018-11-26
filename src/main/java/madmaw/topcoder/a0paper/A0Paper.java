package madmaw.topcoder.a0paper;

public class A0Paper {
    public String canBuild(int[] a) {
        boolean b = this._canBuild(a, 0, 1);
        return b?"Possible":"Impossible";
    }

    private boolean _canBuild(int[] a, int size, int targetQuantity) {
        boolean result;
        if( size < a.length ) {
            int quantity = a[size];
            if( quantity >= targetQuantity ) {
                result = true;
            } else {
                int newTargetQuantity = (targetQuantity - quantity) * 2;
                result = this._canBuild(a, size+1, newTargetQuantity);
            }
        } else {
            result = false;
        }
        return result;
    }
}