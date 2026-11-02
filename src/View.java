import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JLabel;

public class View extends JPanel {
    private Logic logic;
    private int boardWidth = 360;
    private int boardHeight = 640;
    private JLabel scoreLabel;

    public View() {
        logic = new Logic(this);

        setPreferredSize(new java.awt.Dimension(boardWidth, boardHeight));
        setBackground(java.awt.Color.cyan);
        setLayout(null);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(10, 10, 150, 30);
        scoreLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        scoreLabel.setForeground(java.awt.Color.white);

        add(scoreLabel);

        setFocusable(true);
        addKeyListener(logic);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Player player = logic.getPlayer();

        g.setColor(java.awt.Color.yellow);
        g.fillOval(
                player.getX(),
                player.getY(),
                player.getWidth(),
                player.getHeight()
        );

        g.setColor(java.awt.Color.green);

        for (Pipe pipe : logic.getPipes()) {
            g.fillRect(
                    pipe.getX(),
                    pipe.getY(),
                    pipe.getWidth(),
                    pipe.getHeight()
            );
        }

        if (logic.isGameOver()) {
            g.setColor(java.awt.Color.red);
            g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 36));
            g.drawString("GAME OVER", 45, 300);
        }
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void startGame() {
        logic.startGame();
    }
}