import se.lth.cs.pt.window.*;
import se.lth.cs.pt.maze.*;
import java.util.Scanner;

public class MainWalker {
    public static void main(String[] args) {
        
		Scanner scan = new Scanner(System.in);
        System.out.println("Input maze number:");
		int mazeNum = scan.nextInt();
        SimpleWindow w = new SimpleWindow(600, 600, "Maze");
        Maze maze = new Maze(mazeNum);
        maze.draw(w);
        int xEnt = maze.getXEntry();
        int yEnt = maze.getYEntry();
        Turtle turtle = new Turtle(w, xEnt, yEnt);
        MazeWalker mw = new MazeWalker(turtle);
        mw.walker(maze);
        scan.close();
    }
}
