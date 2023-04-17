import se.lth.cs.pt.window.SimpleWindow;
import java.lang.Math;
import se.lth.cs.pt.square.Square;

public class Turtle {

	boolean pen = false;
	double dir = Math.PI / 2;		//90 grader i radianer
	SimpleWindow win;
	int xPos;			//Den faktiska positionen x-koordinaten har
	int yPos;
	double ghostX;		//Den positionen som x-koordinaten hade haft om vi inte hade behövt avrunda talet
	double ghostY;

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början
	 * befinner sig sköldpaddan i punkten x, y med pennan lyft och
	 * huvudet pekande rakt uppåt i fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		win = w;
		xPos = x;
		yPos = y;
		ghostX = x;
		ghostY = y;
	}

	/** Sänker pennan. */
	public void penDown() {
		pen = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		pen = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		win.moveTo((int)ghostX, (int)ghostY);		//Flyttar till en koordinat nära den riktiga koordinaten
		double newxPos = Math.cos(dir) * n;			//Matte
		double newyPos = Math.sin(dir) * n;			//Matte
		
		ghostX += newxPos;							//Mer matte
		ghostY -= newyPos;							//Mer matte
		if (pen) {		//Om penDown
			win.lineTo((int)Math.round(ghostX), (int)Math.round(ghostY));
		}
		else {
			win.moveTo((int)ghostX, (int)ghostY);
		}
		xPos = (int)ghostX;
		xPos = (int)ghostY;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		dir += Math.toRadians(beta);
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	 * eller lyft) och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		win.moveTo(newX, newY);
		ghostX = newX;
		ghostY = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		dir = Math.PI /2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int)Math.round(ghostX);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int)Math.round(ghostY);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		double deg = Math.toDegrees(dir);
		return (int) deg;
	}

	public void cuteTurtle(){
		Square body = new Square(xPos, yPos, 20);
		Square head = new Square(xPos + 6, yPos - 8, 8);
		Square eye1 = new Square(xPos + 7, yPos - 7, 1);
		Square eye2 = new Square(xPos + 12, yPos - 7, 1);
		body.draw(win);
		head.draw(win);
		eye1.draw(win);
		eye2.draw(win);
	}
}
