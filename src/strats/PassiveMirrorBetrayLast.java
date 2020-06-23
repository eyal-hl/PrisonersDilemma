package strats;

import strats.notClasses.Globals;
import strats.notClasses.Strat;

import java.util.ArrayList;

public class PassiveMirrorBetrayLast implements Strat {

    @Override
    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy) {
        if (me.size() == 0)
            return false;
        else if (me.size() == Globals.ROUNDS - 1){
            return true;}
        else
            return enemy.get(enemy.size()-1);
    }
}
