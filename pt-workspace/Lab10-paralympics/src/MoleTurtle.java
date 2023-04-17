public class MoleTurtle extends RaceTurtle{
    RaceTurtle rt;
    RaceWindow rw;
    int startPos;
    int finishPos;
    int turtleNum;

    public MoleTurtle(RaceWindow rw, int startPos) {
        super(rw, startPos);
        this.rw = rw;
        this.startPos = startPos;
        // int xStart = rw.X_START_POS;
        // int yStart = (startPos - 1) * 20 + 124;
        rt = new RaceTurtle(rw, startPos);
    }

    public void raceStep() {
        int b = (int) (Math.random() * (2) + 0);

        if (b == 0) {
            rt.penDown();

        } else if (b == 1) {
            rt.penUp();
        }
        rt.raceStep();
    }

    
    public int getX(){
        return rt.getX();
    }
    public int getY(){
        return rt.getY();
    }

    
    public void name(int turleNum){
        this.turtleNum = turleNum;
    }
    
    public void placement(int finishPos){
        this.finishPos = finishPos;
    }

    public String toString(){
        System.out.println("På plats " + finishPos + ": Nummber " + turtleNum + " - Moleturtle");
        return null;
    }

}