import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class PiggyGame extends JPanel implements KeyListener {
    private static final int TILE_SIZE = 30;

    private static final int ROWS = 10;

    private static final int COLS = 10;
    // 1 = Wall, 0 = Open Path

    private int[][] map = {

        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},

        {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},

        {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},

        {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},

        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},

        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1},

        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},

        {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},

        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

    };




    private int playerX = 1;
    private int playerY = 1;
    public PiggyGame() {
       this.setBackground(Color.BLACK);
       this.setFocusable(true);
       this.addKeyListener(this); }


    private boolean canMove(int x, int y) {

        return map[y][x] != 1; // Wall check

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw Maze Walls

        for (int r = 0; r < ROWS; r++) {

            for (int c = 0; c < COLS; c++) {

                if (map[r][c] == 1) {

                    g.setColor(Color.BLACK);

                    g.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                }

            }

        }
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.GREEN);  
        g.fillOval(playerX, playerY, 30, 30);
 } 

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int newX = playerX;

 int newY = playerY;
       if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) newY--;

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) newY++;

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) newX--;

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) newX++;
        if (canMove(newX, newY)) {

            playerX = newX;

            playerY = newY;

        }
        repaint(); }
        @Override public void keyTyped(KeyEvent e) {}
        @Override public void keyReleased(KeyEvent e) {}
 public static void main(String[] args) {
    JFrame frame = new JFrame("Piggy Pacman");
    PiggyGame gamePanel = new PiggyGame();
    frame.add(gamePanel);
    frame.setSize(320,340);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
 }
}
