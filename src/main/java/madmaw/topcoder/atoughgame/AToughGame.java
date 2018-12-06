package madmaw.topcoder.atoughgame;

public class AToughGame {

    public double expectedGain(int[] prob, int[] value) {

        return _expectedGain(prob, value, 0, 0, 0, 0, 1);
    }

    public double _expectedGain(int[] prob, int[] value, int currentLevel, int currentWealth, int lastDeathLevel, int lastDeathValue, double aggregateProbability) {
        int p = prob[currentLevel];
        int v = value[currentLevel];
        double probability = p / 1000D;
        if( lastDeathLevel == currentLevel ) {
            currentWealth += lastDeathValue;
        }

        // calculate for both options
        double successValue;
        if( currentLevel + 1 < prob.length ) {
            successValue = this._expectedGain(prob, value, currentLevel+1, currentWealth+v, lastDeathLevel, lastDeathValue, aggregateProbability*probability);
        } else {
            successValue = (currentWealth + v);
        }
        // minimum failure probability, always succeed below this threshold
        if( aggregateProbability > 10e-6 && p < 1000 ) {
            double failureValue = (1-probability) * this._expectedGain(prob, value, 0, 0, currentLevel, currentWealth, aggregateProbability * (1-probability));
            return probability * successValue + failureValue;
        } else {
            return successValue;
        }

    }



}
