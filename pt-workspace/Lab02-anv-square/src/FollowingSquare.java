import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class FollowingSquare {
    public static void main(String[] args){
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
            sq.move(xpos, ypos);
            sq.draw(w);
        }
    }
}
