public class AbsentMindTurtle extends RaceTurtle{
    RaceTurtle rt;
    RaceWindow rw;
    int startPos;
    int absent;
    int finishPos;
    int turtleNum;

    public AbsentMindTurtle(RaceWindow rw, int startPos, int absent) {
        super(rw, startPos);
        this.absent = absent;
        this.rw = rw;
        this.startPos = startPos;
        rt = new RaceTurtle(rw, startPos);
    }

    public void raceStep() {
        int b = (int) (Math.random() * (100) + 0);
        if (b > absent) {
            rt.raceStep();
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
        System.out.println("På plats " + finishPos + ": Nummber " + turtleNum + " - AbsentMindTurtle (" + absent + "%) Frånvarande");
        return null;
    }

}