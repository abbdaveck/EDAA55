import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquare {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(500, 500, "Window");
        Square sq = new Square(50, 50, 50);
        sq.draw(w);
        while (true) {
            w.waitForMouseClick();
            sq.erase(w);
            int xpos = w.getClickedX();
            int ypos = w.getClickedY();
            xpos = xpos - sq.getX();
            ypos = ypos - sq.getY();

            for (int i = 0; i < 10; i++) {
                sq.move(xpos / 10, ypos / 10);
                sq.draw(w);
                SimpleWindow.delay(20);
                sq.erase(w);
            }
            sq.draw(w);
        }
    }
}
