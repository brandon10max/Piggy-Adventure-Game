import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class PiggyGame extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.GREEN);  
        g.fillOval(100,100,30,30);
 } 
 public static void main(String[] args) {
    JFrame frame = new JFrame("Piggy Pacman");
    PiggyGame gamePanel = new PiggyGame();
    frame.add(gamePanel);
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
 }
}
