import java.util.ArrayList;
import java.util.List;

public class RacingTime {
    public static void main(String[] args) {
        RaceWindow w = new RaceWindow();
        List<Object> turtles = new ArrayList<Object>();
        List<Object> finishedTurtles = new ArrayList<Object>();
        int finishers = 0;

        for (int i = 0; i < 8; i++) {                       //Jag skapar 8 turtles med random karaktärsdrag samt tillsätter namn
            int rand = (int) (Math.random() * (3) + 0);
            if (rand == 0) {
                turtles.add(new MoleTurtle(w, i + 1));
                ((MoleTurtle) turtles.get(i)).name(i+1);
                System.out.println("Nummer " + (i+1) + " - MoleTurtle");

            } else if (rand == 1) {
                int absentness = rand = (int) (Math.random() * (100) + 0);
                turtles.add(new AbsentMindTurtle(w, i + 1, absentness));
                ((AbsentMindTurtle) turtles.get(i)).name(i+1);
                // ((AbsentMindTurtle) turtles.get(i)).name(i+1);
                System.out.println("Nummer " + (i+1) + " - AbsentMindTurtle (" + absentness + "% Frånvarande)");

            } else if (rand == 2) {
                int dizzyness = rand = (int) (Math.random() * (5) + 1);
                turtles.add(new DizzyTurtle(w, i + 1, dizzyness));
                ((DizzyTurtle) turtles.get(i)).name(i+1);
                System.out.println("Nummer " + (i+1) + " - DizzyTurtle (Yrsel: " + dizzyness + ")");

            }
        }
        
        w.waitForMouseClick();

        while (turtles.size() > 0) {
            w.delay(25);
            for (int i = 0; i < turtles.size(); i++) {
                try {                                           //Då jag inte vet vilket objektettyp jag kallar på när jag itererat genom
                    ((MoleTurtle) turtles.get(i)).raceStep();   //listan måste jag ha en try-catch. Detta eftersom jag måste ha en "cast" innan
                }                                               // jag kallar på objektet t.ex. (MoleTurtle) då jag inte kan ändra den dynamiskt
                catch (Exception e) {
                    try {
                        ((AbsentMindTurtle) turtles.get(i)).raceStep();
                    } 
                    catch (Exception e2) {
                        ((DizzyTurtle) turtles.get(i)).raceStep();
                    }
                }
            }

            for (int i = 0; i < turtles.size(); i++) {
                Boolean passedX = false;
                int turtleType = 0;         //Gör så jag vet vilken typ av turtle som passerade mållinjen så jag slipper ha en till try_catch sen
                try {
                    turtleType = 1;
                    if (((MoleTurtle) turtles.get(i)).getX() > RaceWindow.X_END_POS) { passedX = true;}
                } 
                catch (Exception e) {
                    try {
                        turtleType = 2;
                        if (((AbsentMindTurtle) turtles.get(i)).getX() > RaceWindow.X_END_POS) { passedX = true;}
                    } 
                    catch (Exception e2) {
                        turtleType = 3;
                        if (((DizzyTurtle) turtles.get(i)).getX() > RaceWindow.X_END_POS) { passedX = true;}
                    }
                }
                if (passedX) {
                    finishedTurtles.add(turtles.get(i));
                    turtles.remove(i);
                    finishers++;
                    if (turtleType == 1){
                        ((MoleTurtle) finishedTurtles.get(finishers-1)).placement(finishers);
                    }
                    else if (turtleType == 2){
                        ((AbsentMindTurtle) finishedTurtles.get(finishers-1)).placement(finishers);
                    }
                    else if (turtleType == 3){
                        ((DizzyTurtle) finishedTurtles.get(finishers-1)).placement(finishers);
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            finishedTurtles.get(i).toString();
        }
    }
}
