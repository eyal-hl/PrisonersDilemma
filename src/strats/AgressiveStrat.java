package strats;

import strats.notClasses.Strat;

import java.util.ArrayList;

public class AgressiveStrat implements Strat {
    @Override
    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy) {
        return true;
    }
}
