import se.lth.cs.pt.window.SimpleWindow;
import java.util.concurrent.ThreadLocalRandom;

public class Uppgift6 {
    public static void main(String[] args) {
        System.out.println("Teest");
        SimpleWindow w = new SimpleWindow(600, 600, "Tutle");
        Turtle t1 = new Turtle(w, 250, 250);
        Turtle t2 = new Turtle(w, 350, 350);
        t1.cuteTurtle();
        double dist = 100*Math.sqrt(2);
        t1.penDown();
        t2.penDown();

        while (dist >= 50) {
            int diffX = t1.getX() - t2.getX();
            int diffY = t1.getY() - t2.getY();
            dist = Math.sqrt((diffX*diffX) + (diffY*diffY));
            SimpleWindow.delay(20);

            t1.forward(ThreadLocalRandom.current().nextInt(0, 11));
            t1.left(ThreadLocalRandom.current().nextInt(-180, 181));
            t2.forward(ThreadLocalRandom.current().nextInt(0, 11));
            t2.left(ThreadLocalRandom.current().nextInt(-180, 181));
        }
    }
}



/*
 * Uppgift 7:
 * Attrubut:
 *  Namn: boolean pen (rad 6 i Turtle.java)
 *  Får användas var: den kan nås från alla ställen där vi har importerat klassen Turtle
 * Parameter:
 *  Namn: SimpleWindow w (rad 19 i Turtle.java)
 *  Får användas:
 * Lokal variabel:
 *  Namn: double dist (rad 10 i Uppgift6.java)
 *  Får användas: i funktionen forward 
 */