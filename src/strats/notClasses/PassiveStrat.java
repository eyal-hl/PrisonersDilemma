package strats.notClasses;

import strats.notClasses.Strat;

import java.util.ArrayList;

public class PassiveStrat implements Strat {
    @Override
    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy) {
        return false;
    }
}
