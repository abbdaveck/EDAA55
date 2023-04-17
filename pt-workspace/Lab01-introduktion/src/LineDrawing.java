// import java.nio.file.WatchService;
// import java.time.YearMonth;

import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		while (true) {
			w.waitForMouseClick();
			int xpos = w.getClickedX();
			int ypos = w.getClickedY();
			w.lineTo(xpos, ypos);
		}
	}
}
