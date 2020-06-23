import strats.notClasses.Globals;
import strats.notClasses.Strat;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        ArrayList<Prisoner> prisoners = getPrisoners();

        // Each prisoner play the game versus every other prisoner once.
        for (int i = 0; i < prisoners.size(); i++) {
            for (int j = i+1; j < prisoners.size(); j++) {
                playGame(prisoners.get(i), prisoners.get(j));
            }
        }

        prisoners.sort((prisoner, t1) ->t1.getCurrency() - prisoner.getCurrency());
        prisoners.forEach(Prisoner::printRecord);

    }

    private static void playGame(Prisoner prisoner1, Prisoner prisoner2){
        ArrayList<Boolean> prisonerOneTurns = new ArrayList<>();
        ArrayList<Boolean> prisonerTwoTurns = new ArrayList<>();
        for (int i = 0; i < Globals.ROUNDS; i++) {
            prisonerOneTurns.add(prisoner1.betray(prisonerOneTurns, prisonerTwoTurns));
            prisonerTwoTurns.add(prisoner2.betray(prisonerTwoTurns, prisonerOneTurns));

            if (prisonerOneTurns.get(prisonerOneTurns.size() - 1) && prisonerTwoTurns.get(prisonerTwoTurns.size() - 1)){
                prisoner1.lose();
                prisoner2.lose();
            }
            else if (!prisonerOneTurns.get(prisonerOneTurns.size() - 1) && prisonerTwoTurns.get(prisonerTwoTurns.size() - 1)){
                prisoner1.lose();
                prisoner2.won();
            }
            else if (prisonerOneTurns.get(prisonerOneTurns.size() - 1) && !prisonerTwoTurns.get(prisonerTwoTurns.size() - 1)){
                prisoner1.won();
                prisoner2.lose();
            }
            else {
                prisoner1.tie();
                prisoner2.tie();
            }
        }
    }

    // Getting one of each prisoner strat using reflection.
    private static ArrayList<Prisoner> getPrisoners() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<Prisoner> prisoners = new ArrayList<>();
        Class[] strats = GetClasses.getClasses("strats");
        for (Class strat:strats) {
            if (!strat.getName().contains("notClasses")){
                prisoners.add(new Prisoner((Strat) strat.getConstructor().newInstance()));
            }
        }
        return prisoners;
    }

}
