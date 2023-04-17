import java.util.ArrayList;

public class RacingTime {
    public static void main(String[] args){
        ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();            //Lista för turtles
        ArrayList<RaceTurtle> finishedTurtles = new ArrayList<RaceTurtle>();    //Lista för turtles som gått i mål

        RaceWindow w = new RaceWindow();                                        //Skapar RaceWindow
		RaceTurtle r1 = new RaceTurtle(w, 1);                          //Skapar Turtles
		RaceTurtle r2 = new RaceTurtle(w, 2);
		RaceTurtle r3 = new RaceTurtle(w, 3);
		RaceTurtle r4 = new RaceTurtle(w, 4);
		RaceTurtle r5 = new RaceTurtle(w, 5);
		RaceTurtle r6 = new RaceTurtle(w, 6);
		RaceTurtle r7 = new RaceTurtle(w, 7);
		RaceTurtle r8 = new RaceTurtle(w, 8);

        turtles.add(r1);                                                        //Lägger till dem i listan
        turtles.add(r2);
        turtles.add(r3);
        turtles.add(r4);
        turtles.add(r5);
        turtles.add(r6);
        turtles.add(r7);
        turtles.add(r8);
        int finishers = 0;
        for (int i = 0; i < turtles.size(); i++) {                              //Gör så varje turtle vet vilket namn den har
            turtles.get(i).name(i+1);
        }
        w.waitForMouseClick();
        
        while(turtles.size()>0){                                                //När en turtle har gått i mål tar jag bort den från listan så kör koden tills listan är tom
            w.delay(50);
            for (int i = 0; i < turtles.size(); i++) {
                turtles.get(i).raceStep();                                      //Tar ett steg fram varje gång koden körs
            }
            for (int i = 0; i < turtles.size(); i++) {
                if (turtles.get(i).getX() > RaceWindow.X_END_POS){              //Kollar om dem passerat mållinjen
                    finishers++;                                                   //Antal turtles som gått i mål
                    finishedTurtles.add(turtles.get(i));                        //Lägger till i nya listan
                    finishedTurtles.get(finishers-1).placement(finishers);            //Skriver in vilken plats den gick i mål på
                    turtles.remove(i);                                          //Tar bort från listan med turtles som inte gått i mål än
                }
            }
        }
        for (int i = 0; i < 3; i++) {                                           //Sköldpaddorna läggs till i finishedTurtles i ordningen de går i mål så skriver ut de tre första 
            finishedTurtles.get(i).toString();
        }			
    }
}
