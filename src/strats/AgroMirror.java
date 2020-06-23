package strats;

import strats.notClasses.Strat;

import java.util.ArrayList;

public class AgroMirror implements Strat {
    @Override
    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy) {
        if (me.size() == 0)
            return true;
        else
            return enemy.get(enemy.size()-1);
    }
}
