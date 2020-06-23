package strats.notClasses;

import strats.notClasses.Strat;

import java.util.ArrayList;
import java.util.Random;

public class RandomStrat implements Strat {
    private static Random random = new Random();
    @Override
    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy) {
        return random.nextBoolean();
    }
}
