import java.lang.reflect.Method;

import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
    private int width;
    private int blockSize;
    private int height;

    private SimpleWindow w;

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public char waitForKey() {
        return w.waitForKey();
        }

    public Graphics(int sw, int sh, int bs) {
        width = sw;
        height = sh;
        blockSize = bs;
        this.w = new SimpleWindow(width * blockSize,
                height * blockSize,
                "Digging");

    }

    public void block(int x, int y, java.awt.Color color) {
        w.setLineColor(color);
        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;   //Andral rader är storleken på blocksize dvs 10
        for (int row = top; row <= bottom; row++) {
            w.moveTo(left, row);
            w.lineTo(right, row);
        }
    }

    public void rectangle(int x, int y, int width, int height, java.awt.Color c) {
        for (int yy = y; yy < y + height; yy++){
            for(int xx = x; xx < x + width; xx++){
            block(xx, yy, c);
            }
            }
            //Blocken ritas ut rad för rad ovanifrån och ned
    }
    
    // public void square() {
    //     // Fyll i koden för att rita en kvadrat här.
    //     // Observera att w är definerat ovan.
    //     w.moveTo(10, 10);
    //     w.lineTo(10, 20);
    //     w.lineTo(20, 20);
    //     w.lineTo(20, 10);
    //     w.lineTo(10, 10);
    // }
}
