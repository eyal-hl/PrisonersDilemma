import strats.notClasses.Globals;
import strats.notClasses.Strat;

import java.util.ArrayList;

public class Prisoner {
    private int currency;
    private int winCounter;
    private int tieCounter;
    private int loseCounter;
    private Strat strat;

    public Prisoner(Strat strat){
        currency = 0;
        winCounter = 0;
        tieCounter = 0;
        loseCounter = 0;
        this.strat = strat;
    }

    public void tie(){
        currency += Globals.TIE_MONEY;
        tieCounter++;
    }

    public void won(){
        currency += Globals.WIN_MONEY;
        winCounter++;
    }

    public void lose(){
        loseCounter++;
    }

    public void printRecord(){
        System.out.println(String.format("%s\nmoney: %s\nwon: %s\ntied: %s\nlost: %s\n", getStratName(), getCurrency(), winCounter, tieCounter, loseCounter));
    }

    public int getCurrency(){
        return currency;
    }

    public String getStratName(){
        return strat.getClass().getSimpleName();
    }

    public boolean betray(ArrayList<Boolean> me, ArrayList<Boolean> enemy){
        return strat.betray(me, enemy);
    }
}
