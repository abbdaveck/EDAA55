import se.lth.cs.pt.window.SimpleWindow;
import java.util.concurrent.ThreadLocalRandom;

public class Uppgift5 {
    public static void main(String[] args) {
        System.out.println("Teest");
        SimpleWindow w = new SimpleWindow(600, 600, "Tutle");
        Turtle t = new Turtle(w, 300, 300);
        t.penDown();
        for (int i = 0; i < 1001; i++) {
            t.forward(ThreadLocalRandom.current().nextInt(0, 11));
            t.left(ThreadLocalRandom.current().nextInt(-180, 181));
        }
    }
}