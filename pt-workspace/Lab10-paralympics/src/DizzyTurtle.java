public class DizzyTurtle extends RaceTurtle{
    RaceTurtle rt;
    RaceWindow rw;
    int startPos;
    int dizzy;
    int dizzyCount = 0;
    int finishPos;
    int turtleNum;
    int rand = (int) (Math.random() * (5) + 0) - 2;

    public DizzyTurtle(RaceWindow rw, int startPos, int dizzy) {
        super(rw, startPos);
        this.dizzy = dizzy;
        this.rw = rw;
        this.startPos = startPos;
        rt = new RaceTurtle(rw, startPos);
    }

    public void raceStep() {
        if (dizzyCount < 10){
            rt.offCourse(rand*dizzy);
            rt.raceStep();
            dizzyCount++;
        }
        else {
            rand = (int) (Math.random() * (5) + 0) - 2;
            dizzyCount = 0;
        }
    }

    public int getX() {
        return rt.getX();
    }

    public int getY() {
        return rt.getY();
    }

    
    public void name(int turleNum){
        this.turtleNum = turleNum;
    }
    
    public void placement(int finishPos){
        this.finishPos = finishPos;
    }

    public String toString(){
        System.out.println("På plats " + finishPos + ": Nummber " + turtleNum + " - DizzyTurtle (Yrsel: " + dizzy + ")");

        return null;
    }
}