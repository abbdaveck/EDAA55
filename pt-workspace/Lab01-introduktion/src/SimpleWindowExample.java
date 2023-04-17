import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");
        w.moveTo(100,100);
        w.lineTo(150, 100);
        w.lineTo(150, 50);
        w.setLineColor(Color.RED);
        w.setLineWidth(5);
        w.lineTo(100, 50);
        w.lineTo(100, 100);
    }
}