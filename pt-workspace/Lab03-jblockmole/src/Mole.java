public class Mole {
    Graphics g = new Graphics(30, 50, 10);

    private int windowHeight = 50;
    private int windowWidth = 30;

    public static void main(String[] args) {
        System.out.println("Keep on digging");

        Mole m = new Mole();
        m.drawWorld();
        m.dig();
    }

    public void drawWorld() {
        g.rectangle(0, 0, windowWidth, windowHeight, Colors.SOIL);
    }

    public void dig() {
        int x = g.getWidth() / 2; // För att börja på mitten
        int y = g.getHeight() / 2;
        while (true) {
            g.block(x, y, Colors.MOLE);
            char key = g.waitForKey();
            g.block(x, y, Colors.TUNNEL);
            if (key == 'w') {
                y -= 1;         //y positionen blir 1 mindre, dvs den går upp en koordinat
                } 
            else if (key == 'a') {
                x -= 1;
                } 
            else if (key == 's') {
                y += 1;
            } 
            else if (key == 'd') {
                x += 1;
            }
            System.out.println(x+" " +y);
            g.block(x, y, Colors.MOLE);     //Sätter ett block på nya positionen

        }
    }
}
