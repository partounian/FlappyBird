import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
 private static final long serialVersionUID = 4909609457314838721L;
 private Game game;
 private Pipe pipe;
 Font f = new Font("Helvetica", Font.BOLD, 50);


    public GamePanel() {
        game = new Game();
        new Thread(this).start();
    }

    public GamePanel(int i) {

    }

    public void update() {
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(f);
        g.setColor(Color.GREEN);

        Graphics2D g2D = (Graphics2D) g;

        for (Render r : game.getRenders())
            if (r.transform != null)
                g2D.drawImage(r.image, r.transform, null);
            else
                g.drawImage(r.image, r.x, r.y, null);
        
        if (game.gameover) {
            game.paused = true;
            g.setColor(Color.RED);
            g.drawString("Game Over", 100, 100);
            g.drawString(Integer.toString(game.points), 150, 150);
        }
    }
 
    public void run() {
        try {
            while (true) {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
