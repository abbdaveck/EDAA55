import java.lang.Math;


public class RaceTurtle {

    RaceWindow rw;
    int startPos;
    int finishPos;
    int turtleNum;
    Turtle t;

    public RaceTurtle(RaceWindow rw, int startPos){
        this.rw = rw;
        this.startPos = startPos;
        int xStart = rw.X_START_POS;
        int yStart = (startPos-1) * 20 + 124;
        t = new Turtle(rw, xStart, yStart);
        t.left(-90);
        t.penDown();
    }

    public void raceStep(){                     //Tar ett steg som är mellan 1 och 6 koordinater stora
        int b = (int)(Math.random()*(6)+1);
        t.forward(b);

    }
    public int getX(){
        return t.getX();
    }
    public int getY(){
        return t.getY();
    }

    public void name(int turleNum){
        this.turtleNum = turleNum;
    }

    public void placement(int finishPos){
        this.finishPos = finishPos;
    }

    public String toString(){
        System.out.println("Turtle " + turtleNum + " finished: " + finishPos);
        return null;
    }
}
