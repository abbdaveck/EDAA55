import se.lth.cs.pt.window.*;
import se.lth.cs.pt.maze.*;
import java.util.Scanner;


public class MazeWalker {
    private Turtle t1;

    public MazeWalker(Turtle turtle){
        this.t1 = turtle;

    }

    public void walker(Maze m){


        t1.penDown();
        t1.forward(1);
        t1.left(90);

        while (!m.atExit(t1.getX(), t1.getY())) {         //Kör om samma loop tills jag hittat utgången
            if (m.wallAtLeft(t1.getDirection(), t1.getX(), t1.getY()) && !m.wallInFront(t1.getDirection(), t1.getX(), t1.getY())){    //Om det finns vägg vänster och ingen vägg framför gå bara framåt
                SimpleWindow.delay(2);
            }
            else if (!m.wallAtLeft(t1.getDirection(), t1.getX(), t1.getY()) && !m.wallInFront(t1.getDirection(), t1.getX(), t1.getY())){  //Om ingen vägg vänster och ingen vägg framför sväng vänster
                t1.left(90);
            }
            else{       //Annars sväng höger
                t1.left(-90);
            }
            if (m.wallAtLeft(t1.getDirection(), t1.getX(), t1.getY()) && m.wallInFront(t1.getDirection(), t1.getX(), t1.getY())){     //Om jag hamnar i en återvändsgränd dvs, att de är väggar framåt höger och vänster ska jag svänga höger igen
                t1.left(-90);
            }
            t1.forward(1);       //Gå framåt
        }
    }
}
