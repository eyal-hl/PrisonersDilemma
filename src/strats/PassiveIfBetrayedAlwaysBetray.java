package strats;

import strats.notClasses.Strat;

import java.util.ArrayList;

public class PassiveIfBetrayedAlwaysBetray implements Strat {
    @Override
    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy) {
        if (me.size() == 0)
            return false;

        else
            return enemy.contains(true);
    }
}
